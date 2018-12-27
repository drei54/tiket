package com.tiket.test.intermediate.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.tiket.test.intermediate.dao.CustomerDao;
import com.tiket.test.intermediate.dao.EmployeeDao;
import com.tiket.test.intermediate.dao.OrderDao;
import com.tiket.test.intermediate.dao.OrderDetailDao;
import com.tiket.test.intermediate.dao.ProductDao;
import com.tiket.test.intermediate.dao.ShippingMethodDao;
import com.tiket.test.intermediate.entity.Customer;
import com.tiket.test.intermediate.entity.Employee;
import com.tiket.test.intermediate.entity.Order;
import com.tiket.test.intermediate.entity.OrderDetail;
import com.tiket.test.intermediate.entity.Product;
import com.tiket.test.intermediate.entity.ShippingMethod;
import com.tiket.test.senior.reactiverepository.ReactiveCustomerRepository;
import com.tiket.test.senior.reactiverepository.ReactiveEmployeeRepository;
import com.tiket.test.senior.reactiverepository.ReactiveOrderDetailRepository;
import com.tiket.test.senior.reactiverepository.ReactiveOrderRepository;
import com.tiket.test.senior.reactiverepository.ReactiveProductRepository;
import com.tiket.test.senior.reactiverepository.ReactiveShippingMethodRepository;

import reactor.core.publisher.Flux;

@Component
public class FileUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private ShippingMethodDao shippingMethodDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private ReactiveCustomerRepository customerRepository;

	@Autowired
	private ReactiveShippingMethodRepository shippingMethodRepository;

	@Autowired
	private ReactiveEmployeeRepository employeeRepository;

	@Autowired
	private ReactiveOrderRepository orderRepository;

	@Autowired
	private ReactiveOrderDetailRepository orderDetailRepository;

	@Autowired
	private ReactiveProductRepository productRepository;

	ObjectMapper objectMapper = new ObjectMapper();

	public  <T> List<T> loadObjectList(Class<T> type, String fileName) {
	    try {
	        /*CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
	        CsvMapper mapper = new CsvMapper();
	        File file = new ClassPathResource(fileName).getFile();
	        MappingIterator<T> readValues = mapper.reader(type).with(bootstrapSchema).readValues(file);
	        return readValues.readAll();
	        */
	        // Schema from POJO (usually has @JsonPropertyOrder annotation)
	        File file = new ClassPathResource(fileName).getFile();
	        ObjectMapper mapper = new CsvMapper();
//	        CsvSchema schema = mapper.schemaFor(type);

	        // Read schema from the first line; start with bootstrap instance
	        // to enable reading of schema from the first line
	        // NOTE: reads schema and uses it for binding
	        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
	        MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema).readValues(file);
	        return readValues.readAll();
	    } catch (Exception e) {
	        logger.error("Error occurred while loading object list from file " + fileName, e);
	        return Collections.emptyList();
	    }	
	}
	
	public List<ShippingMethod> readShippingMethod()
	{
		BufferedReader fileReader = null;		 
		List<ShippingMethod> list = new ArrayList<ShippingMethod>();
		try {
			String line = "";
			File file = new ClassPathResource("/static/csv/ShippingMethods.csv").getFile();
			fileReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
 
			// Read CSV header
			fileReader.readLine();
 
			// Read customer data line by line
			shippingMethodRepository.deleteAll().subscribe();
			while ((line = fileReader.readLine()) != null) {
				String[] cols = line.split(";");
				if (cols.length > 0) {
					ShippingMethod o = new ShippingMethod(Long.parseLong(cols[0]), cols[1]);					
					shippingMethodDao.save(o);
//					if(shippingMethodRepository.findByShippingMethodId(o.getShippingMethodId()) == null) {
						com.tiket.test.senior.model.ShippingMethod shippingMethod = objectMapper.readValue(objectMapper.writeValueAsString(o), com.tiket.test.senior.model.ShippingMethod.class);
						shippingMethodRepository.save(shippingMethod).subscribe();
//					}
					list.add(o);
				}
			}
 
		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader Error!");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Customer> readCustomer()
	{
		BufferedReader fileReader = null;		 
		List<Customer> list = new ArrayList<Customer>();
		try {
			String line = "";
			File file = new ClassPathResource("/static/csv/Customers.csv").getFile();
			fileReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
 
			// Read CSV header
			fileReader.readLine();
 
			// Read customer data line by line
			String values = "";
			customerRepository.deleteAll().subscribe();
			while ((line = fileReader.readLine()) != null) {
				if(line.contains(";\"")) {
					values = line;
					continue;
				}else if(line.contains("\";")) {
					values += line;
				}else {
					values = line;
				}
				String[] cols = values.split(";");
				if (cols.length > 0) {
					if(cols[9].contains("\"")) {
						String[] urls = cols[9].replace("\"", "").toString().split("http");
						cols[9] = "http"+urls[1];
					}
					
					Customer o = new Customer(Long.parseLong(cols[0]), cols[1], cols[2], cols[3], cols[4], cols[5], cols[6], cols[7], cols[8], cols[9], 
							cols[10], cols[11], cols[12], cols[13], cols[14], cols[15], cols[16]);		
					customerDao.save(o);
					com.tiket.test.senior.model.Customer obj = objectMapper.readValue(objectMapper.writeValueAsString(o), com.tiket.test.senior.model.Customer.class);
					customerRepository.save(obj).subscribe();
					/*if(customerRepository.findByCustomerId(o.getCustomerId()) == null) {
						customerRepository.save(o);
					}*/
					list.add(o);
					
				}
			}
 
 
		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader Error!");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Employee> readEmployee()
	{
		BufferedReader fileReader = null;		 
		List<Employee> list = new ArrayList<Employee>();
		try {
			String line = "";
			File file = new ClassPathResource("/static/csv/Employees.csv").getFile();
			fileReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
 
			// Read CSV header
			fileReader.readLine();
 
			// Read customer data line by line
			employeeRepository.deleteAll().subscribe();
			while ((line = fileReader.readLine()) != null) {
				String[] cols = line.split(";");
				if (cols.length > 0) {
					Employee o = new Employee(Long.parseLong(cols[0]), cols[1], cols[2],cols[3], cols[4]);					
					employeeDao.save(o);
					com.tiket.test.senior.model.Employee obj = objectMapper.readValue(objectMapper.writeValueAsString(o), com.tiket.test.senior.model.Employee.class);
					employeeRepository.save(obj).subscribe();
					/*if(employeeRepository.findByEmployeeId(o.getEmployeeId()) == null) {
						employeeRepository.save(o);
					}*/
					list.add(o);
				}
			}
 
 
		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader Error!");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Product> readProduct()
	{
		BufferedReader fileReader = null;		 
		List<Product> list = new ArrayList<Product>();
		try {
			String line = "";
			File file = new ClassPathResource("/static/csv/Products.csv").getFile();
			fileReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
 
			// Read CSV header
			fileReader.readLine();
 
			// Read customer data line by line
			productRepository.deleteAll().subscribe();
			while ((line = fileReader.readLine()) != null) {
				String[] cols = line.split(";");
				if (cols.length > 0) {
					Product o = new Product(Long.parseLong(cols[0]), cols[1], Double.parseDouble(cols[2].replace(",", ".")),Integer.parseInt(cols[3]));
					productDao.save(o);
					com.tiket.test.senior.model.Product obj = objectMapper.readValue(objectMapper.writeValueAsString(o), com.tiket.test.senior.model.Product.class);
					productRepository.save(obj).subscribe();
					/*if(productRepository.findByProductId(o.getProductId()) == null) {
						productRepository.save(o);
					}*/
					list.add(o);
				}
			}
 
 
		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader Error!");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Order> readOrder()
	{
		BufferedReader fileReader = null;		 
		List<Order> list = new ArrayList<Order>();
		try {
			String line = "";
			File file = new ClassPathResource("/static/csv/Orders.csv").getFile();
			fileReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
 
			// Read CSV header
			fileReader.readLine();
 
			// Read customer data line by line
			orderRepository.deleteAll().subscribe();
			while ((line = fileReader.readLine()) != null) {
				String[] cols = line.split(";");
				if (cols.length > 0) {
//					long id, Customer customer, Employee employee,Date OrderDate,String purchaseOrderNumber,Date shipDate,ShippingMethod shippingMethod,Integer freightCharge,Integer taxes,Integer paymentReceived,String comment
					Customer customer = customerDao.findByCustomerId(Long.parseLong(cols[1]));
					Employee employee = employeeDao.findByEmployeeId(Long.parseLong(cols[2]));
					SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date orderDate = sdf.parse(cols[3]);
					Date shipDate = (cols[5] == null || cols[5].isEmpty()) ? null : sdf.parse(cols[5]);
					ShippingMethod shippingMethod = shippingMethodDao.findByShippingMethodId(Long.parseLong(cols[6]));
					String comment = (cols.length == 11)? cols[10] :"" ;
					Integer freightCharge = (cols[7].isEmpty()) ? null : Integer.parseInt(cols[7]);
					Order o = new Order(Long.parseLong(cols[0]), customer, employee, orderDate, cols[4], shipDate, shippingMethod, freightCharge, Integer.parseInt(cols[8]), Integer.parseInt(cols[9]), comment);
					logger.info("OrderID "+ o.getOrderId());
					orderDao.save(o);
					com.tiket.test.senior.model.Order obj = objectMapper.readValue(objectMapper.writeValueAsString(o), com.tiket.test.senior.model.Order.class);
					orderRepository.save(obj).subscribe();
					/*if(orderRepository.findByOrderId(o.getOrderId()) == null) {
						orderRepository.save(o);
					}*/
					list.add(o);
				}
			}
 
 
		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader Error!");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<OrderDetail> readOrderDetail()
	{
		BufferedReader fileReader = null;		 
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		try {
			String line = "";
			File file = new ClassPathResource("/static/csv/OrderDetails.csv").getFile();
			fileReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
 
			// Read CSV header
			fileReader.readLine();
 
			// Read customer data line by line
			orderDetailRepository.deleteAll().subscribe();
			while ((line = fileReader.readLine()) != null) {
				String[] cols = line.split(";");
				if (cols.length > 0) {
					//long id,Order order,Product product,Integer quantity,Double unitPrice,Double discount
					Order order = orderDao.findByOrderId(Long.parseLong(cols[1]));
					Product product = productDao.findByProductId(Long.parseLong(cols[2]));
					OrderDetail o = new OrderDetail(Long.parseLong(cols[0]), order, product, Integer.parseInt(cols[3]), Double.parseDouble(cols[4].replace(",", ".")), Double.parseDouble(cols[5].replace(",", ".").replaceAll("%", "")));
					orderDetailDao.save(o);
					com.tiket.test.senior.model.OrderDetail obj = objectMapper.readValue(objectMapper.writeValueAsString(o), com.tiket.test.senior.model.OrderDetail.class);
					com.tiket.test.senior.model.Order ord = objectMapper.readValue(objectMapper.writeValueAsString(order), com.tiket.test.senior.model.Order.class);
					obj.setOrder(ord);
					orderDetailRepository.save(obj).subscribe();
					/*if(orderDetailRepository.findByOrderDetailId(o.getOrderDetailId()) == null) {
						orderDetailRepository.save(o);
					}*/
					list.add(o);
				}
			}
 
		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader Error!");
				e.printStackTrace();
			}
		}
		return list;
	}

}
