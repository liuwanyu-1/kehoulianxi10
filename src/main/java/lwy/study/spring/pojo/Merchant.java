package lwy.study.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Merchant {
    @Value("1")
    private Integer mid;
    @Value("卡旺卡奶茶店")
    private String mname;
    @Value("合肥市蜀山区长江西路189号")
    private String maddress;
}
