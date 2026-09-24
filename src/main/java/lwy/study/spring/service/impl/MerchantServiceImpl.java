package lwy.study.spring.service.impl;

import lwy.study.spring.dao.IMerchantDao;
import lwy.study.spring.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("merchantService")
public class MerchantServiceImpl implements IMerchantService {
    @Autowired
    private IMerchantDao merchantDao;

    @Override
    public void save() {
        merchantDao.save();
        System.out.println("执行MerchantServiceImpl.save()");
    }
}
