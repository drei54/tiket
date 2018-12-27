package com.tiket.test.intermediate.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiket.test.common.enums.ResponseCode;
import com.tiket.test.common.response.GenericResponse;
import com.tiket.test.intermediate.entity.Customer;
import com.tiket.test.intermediate.entity.Employee;
import com.tiket.test.intermediate.entity.Order;
import com.tiket.test.intermediate.entity.OrderDetail;
import com.tiket.test.intermediate.entity.Product;
import com.tiket.test.intermediate.entity.ShippingMethod;
import com.tiket.test.intermediate.util.FileUtil;

@RestController
public class FileController {
	private Logger logger = Logger.getLogger(FileController.class.getName());

	@Autowired
	private FileUtil fileUtil;

	@RequestMapping("/file/load")
	@ResponseBody
	public GenericResponse insertCustomerFromCsv() {
		List<ShippingMethod> shippingMethods = fileUtil.readShippingMethod();		
		List<Customer> customers = fileUtil.readCustomer();
		List<Employee> employees = fileUtil.readEmployee();
		List<Product> products = fileUtil.readProduct();
		List<Order> orders = fileUtil.readOrder();
		List<OrderDetail> orderDetails = fileUtil.readOrderDetail();
		GenericResponse resp = new GenericResponse(orderDetails, ResponseCode.SUCCESS);
		
		return resp;
	}

}
