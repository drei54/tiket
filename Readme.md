------------------------------------
A
--------------------------------
/tiket/src/main/java/com/tiket/test/basic/SoalA.java
/tiket/src/main/java/com/tiket/test/basic/SoalB.java

------------------------------------
B
--------------------------------
#Index page
http://localhost:8080

#Load data from csv to mysql
http://localhost:8080/file/load

#Rest 
http://localhost:8080/order?page=1&size=1

#Query
#Daftar pelanggan yang beralamat di kota Irvine
<pre>
SELECT * 
FROM customer 
WHERE city = 'Irvine';
</pre>

#Daftar semua pelanggan yang pesanannya ditangani karyawan bernama Adam Barr
<pre>
SELECT c.* 
FROM customer c
LEFT JOIN `order` o ON c.customer_id = o.`customer_id`
LEFT JOIN `employee` e ON e.employee_id = o.`employee_id`
WHERE CONCAT(e.first_name,' ',e.last_name) = 'Adam Barr' 
GROUP BY c.customer_id;
</pre>

#Daftar produk yang dipesan oleh pelanggan Contoso, Ltd
<pre>
SELECT p.* 
FROM `order_detail` od
LEFT JOIN `order` o ON o.order_id = od.`order_id`
JOIN `customer` c ON c.customer_id = o.`customer_id`
JOIN `product` p ON p.product_id = od.`product_id`
WHERE c.company_name= 'Contoso, Ltd' 
GROUP BY p.product_id;
</pre>

#Daftar transaksi pemesanan yang dikirimkan melalui UPS Ground
<pre>
SELECT o.* 
FROM `order` o 
JOIN `shipping_method` sm ON sm.shipping_method_id = o.`shipping_method_id`
WHERE sm.shipping_method = 'UPS Ground' ;
</pre>

#Daftar biaya total pemesanan (termasuk pajak dan biaya pengiriman) setiap transaksi diurut berdasarkan tanggal transaksi
<pre>
SELECT 
	tanggal_transaksi, 
	SUM(taxes) AS biaya_pajak, 
	SUM(IFNULL(freight_charge, 0)) AS biaya_pengiriman, 
	SUM(harga_pemesanan) AS biaya_pemesanan, 
	SUM(total_biaya) AS total_biaya
FROM 
(
	SELECT 
		DATE(order_date) AS tanggal_transaksi, 
		taxes, 
		freight_charge,
		(
			SELECT SUM((od.quantity * od.unit_price) - (od.quantity * od.unit_price * od.discount / 100 ))
			FROM order_detail od
			WHERE order_id = o.`order_id`
		) AS harga_pemesanan,
		(taxes + IFNULL(freight_charge,0) + (
			SELECT SUM((od.quantity * od.unit_price) - (od.quantity * od.unit_price * od.discount / 100 ))
			FROM order_detail od
			WHERE order_id = o.`order_id`
		)) AS total_biaya
	FROM `order` o
) AS view1
GROUP BY tanggal_transaksi
ORDER BY tanggal_transaksi
</pre>

------------------------------------
C
--------------------------------
#Load data from csv to mongodb
http://localhost:8080/file/load

#Rest Reactive WebFlux with MongoDB
http://localhost:8080/reactive/order
<br>
http://localhost:8080/reactive/customer
<br>
http://localhost:8080/reactive/order-detail
<br>
http://localhost:8080/reactive/product
<br>
http://localhost:8080/reactive/employee

#Query MongoDB
use tiket
#Daftar pelanggan yang beralamat di kota Irvine
<pre>
db.customer.find({shipCity:"Irvine"})
</pre>

#Daftar semua pelanggan yang pesanannya ditangani karyawan bernama Adam Barr
<pre>
db.order.find({"employee.firstName": "Adam","employee.lastName": "Barr"},{"customer":1}).pretty()
</pre>

#Daftar produk yang dipesan oleh pelanggan Contoso, Ltd
<pre>
db.orderDetail.aggregate([
  	{
     	$lookup:
       	{
         	from: "order",
         	localField: "order.orderId",
         	foreignField: "orderId",
         	as: "fromOrder"
       	}
  	},
  	{
        "$unwind": "$fromOrder"
    },
  	{ $project : { product: 1 } }
]).pretty()
</pre>

#Daftar transaksi pemesanan yang dikirimkan melalui UPS Ground
<pre>
db.order.find({"shippingMethod.shippingMethod": "UPS Ground"},{"orderId":1, "OrderDate":2, "purchaseOrderNumber":3, "shipDate":4, "taxes":5, "customer.firstName":6, "employee.firstName":7}).pretty()
</pre>

#Daftar biaya total pemesanan (termasuk pajak dan biaya pengiriman) setiap transaksi diurut berdasarkan tanggal transaksi

