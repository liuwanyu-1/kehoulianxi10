package lwy.study.spring.pojo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotationBeans {
    ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("annotation_beans.xml");
    }

    @Test
    public void testComponent() {
        Customer customer = applicationContext.getBean("customer", Customer.class);
        System.out.println(customer);
    }

    @Test
    public void testAutoWire() {
        Orders orders = applicationContext.getBean("orders", Orders.class);
        System.out.println(orders);
    }
}
