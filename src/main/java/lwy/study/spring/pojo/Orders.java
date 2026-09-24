package lwy.study.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Orders {
    @Value("1001")
    private Integer oid;
    @Value("WY20260924001")
    private String ono;
    @Value("黑糖奶茶大杯")
    private String ogoods;
    @Value("16.0")
    private Double oprice;
    @Value("1")
    private Integer mid;
    //引用类型的属性，形成实例时，需要进行依赖注入（DI）
    @Autowired
    @Qualifier("customer")
    private Customer customer;
}
