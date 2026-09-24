package lwy.study.spring.controller;

import lwy.study.spring.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("merchantController")
public class MerchantController {
    @Autowired
    private IMerchantService merchantService;

    public void save() {
        this.merchantService.save();
        System.out.println("执行MerchantController.save()");
    }
}
