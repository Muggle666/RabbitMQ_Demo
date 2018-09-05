package com.hao.rabbitmq;

import com.hao.rabbitmq.Model.Order;
import com.hao.rabbitmq.Producer.RabbitOrderSender;
import com.hao.rabbitmq.Service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private RabbitOrderSender orderSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendTest() throws Exception{
        Order order = new Order();
        order.setId("2");
        order.setName("Katy");
        order.setMessageId(System.currentTimeMillis() + "$"  + UUID.randomUUID().toString());
        orderSender.sendOrder(order);
    }

    @Autowired
    private OrderService service;

    @Test
    public void sendOrder() throws Exception {
        Order order = new Order();
        order.setId("10");
        order.setName("Katy");
        order.setMessageId(System.currentTimeMillis() + "$"  + UUID.randomUUID().toString());
        service.createOrder(order);
    }
}
