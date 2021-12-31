package com.hibernate.console.controller;

import com.hibernate.console.model.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {
    private OrderController orderController = new OrderController();
    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order("test");
        orderController.saveOrder(order);
    }

    @AfterEach
    void tearDown() {
        orderController.deleteOrder(order.getId());
    }

    @Test
    void printAllOrdersTest() {
        assertTrue(orderController.printAll().size() > 0);
    }

    @Test
    void saveOrderTest() {
        assertEquals(order, orderController.getValueByIndex(order.getId()));
    }

    @Test
    void deleteOrderTest() {
        Order orderDelete = new Order("test_delete");
        orderController.saveOrder(orderDelete);
        orderController.deleteOrder(orderDelete.getId());
        assertNull(orderController.getValueByIndex(orderDelete.getId()), "Order should be null");
    }

    @Test
    void updateOrderTest() {
        order.setOrderName("test_update");
        orderController.updateOrder(order.getId(), order);
        String updateName = orderController.getValueByIndex(order.getId()).getOrderName();
        assertEquals("test_update", updateName);
    }

    @Test
    void getValueByIndexTest() {
        assertNotNull(orderController.getValueByIndex(order.getId()));
    }
}