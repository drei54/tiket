package com.tiket.test.intermediate.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiket.test.common.enums.ResponseCode;
import com.tiket.test.common.response.GenericResponse;
import com.tiket.test.intermediate.dao.OrderDao;
import com.tiket.test.intermediate.dao.OrderDetailDao;
import com.tiket.test.intermediate.entity.Order;
import com.tiket.test.intermediate.entity.OrderDetail;

@RestController
public class OrderController {
	private Logger logger = Logger.getLogger(OrderController.class.getName());

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@RequestMapping("/order")
	@ResponseBody
	public GenericResponse restOrder(final Pageable pageable) {
		Page<Order> orders = orderDao.findAll(pageable);
		for(int i=0; i< orders.getContent().size(); i++) {
			List<OrderDetail> orderDetails = orderDetailDao.findByOrderOrderId(orders.getContent().get(i).getOrderId());
			Double subTotal = 0d;
			Double orderTotal = 0d;
			for(OrderDetail orderDetail : orderDetails) {
				Double hargaPesanan = orderDetail.getQuantity() * orderDetail.getUnitPrice();
				Double discount = hargaPesanan * orderDetail.getDiscount() / 100;
				subTotal = subTotal + (hargaPesanan - discount);
			}
			int freightCharge = (orders.getContent().get(i).getFreightCharge() == null) ? 0 : orders.getContent().get(i).getFreightCharge();
			orderTotal = subTotal + orders.getContent().get(i).getTaxes() + freightCharge;
			
			orders.getContent().get(i).setOrderDetails(orderDetails);
			orders.getContent().get(i).setSubTotal(subTotal);
			orders.getContent().get(i).setOrderTotal(orderTotal);
		}
		GenericResponse resp = new GenericResponse(orders, ResponseCode.SUCCESS);
		
		return resp;
	}
}
