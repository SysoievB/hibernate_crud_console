package com.hibernate.console.util;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HibernateUtilTest {

    @Test
    void getSessionFactoryTest() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        assertNotNull(sessionFactory,"Connection should be successful");
    }
}