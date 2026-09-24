package lwy.study.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component("customer")
@Scope(value = "singleton")
public class Customer {
    @Value("3001")
    private Integer cid;
    @Value("陈晓")
    private String cname;
    @Value("13800001234")
    private String ctel;
    @Value("合肥市蜀山区大学城商业街")
    private String caddress;
}
