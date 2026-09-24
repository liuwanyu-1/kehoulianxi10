package lwy.study.spring.dao.impl;

import lwy.study.spring.dao.IMerchantDao;
import lwy.study.spring.pojo.Merchant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository("merchantDao")
public class MerchantDaoImpl implements IMerchantDao {
    public void save() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Merchant merchant = (Merchant) applicationContext.getBean("merchant");
        System.out.println(merchant);
        System.out.println("执行MerchantDaoImpl.save()");
    }
}
