-- Daftar pelanggan yang beralamat di kota Irvine
SELECT * 
FROM customer 
WHERE city = 'Irvine';

-- Daftar semua pelanggan yang pesanannya ditangani karyawan bernama Adam Barr
SELECT c.* 
FROM customer c
LEFT JOIN `order` o ON c.customer_id = o.`customer_id`
LEFT JOIN `employee` e ON e.employee_id = o.`employee_id`
WHERE CONCAT(e.first_name,' ',e.last_name) = 'Adam Barr' 
GROUP BY c.customer_id;

-- Daftar produk yang dipesan oleh pelanggan Contoso, Ltd
SELECT p.* 
FROM `order_detail` od
LEFT JOIN `order` o ON o.order_id = od.`order_id`
JOIN `customer` c ON c.customer_id = o.`customer_id`
JOIN `product` p ON p.product_id = od.`product_id`
WHERE c.company_name= 'Contoso, Ltd' 
GROUP BY p.product_id;

-- Daftar transaksi pemesanan yang dikirimkan melalui UPS Ground
SELECT o.* 
FROM `order` o 
JOIN `shipping_method` sm ON sm.shipping_method_id = o.`shipping_method_id`
WHERE sm.shipping_method = 'UPS Ground' ;

-- Daftar biaya total pemesanan (termasuk pajak dan biaya pengiriman) setiap transaksi diurut berdasarkan tanggal transaksi
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

