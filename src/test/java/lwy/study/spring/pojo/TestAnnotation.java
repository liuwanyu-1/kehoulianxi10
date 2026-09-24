package lwy.study.spring.pojo;

import lwy.study.spring.controller.MerchantController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MerchantController merchantController = (MerchantController) applicationContext.getBean("merchantController");
        merchantController.save();
    }
}
