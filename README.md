# kehoulianxi10 —— 课后作业：自选表注解分层（2026-09-24）

## 作业要求（老师口述）

1. 自己选业务表，把课上 User 那套分层代码换成自己的表
2. 分层完整：实体类 + DAO 接口/实现（`@Repository`）+ Service 接口/实现（`@Service`），Service 里用 `@Autowired` 注入 DAO
3. XML 里必须配 `<context:component-scan>` 扫描自己的业务包，不写扫描注解不生效
4. 测试类：`ClassPathXmlApplicationContext` 加载配置，从容器取 Service（本工程还取了 Controller）调业务方法
5. 参考课上 User 分层案例的结构逻辑

## 自选表声明（重要）

每人分配的业务表不同，本工程使用**开学分配的外卖三件套**（与本人 MyBatis 阶段作业同体系的表）：

| 表 | 实体 | 字段 | 示例数据 |
|---|---|---|---|
| 店铺信息表 | `Merchant` | mid / mname / maddress | 1 卡旺卡奶茶店 合肥市蜀山区长江西路189号 |
| 外卖订单表 | `Orders` | oid / ono / ogoods / oprice / mid（外键→店铺） | 1001 WY20260924001 黑糖奶茶大杯 16.0 |
| 食客信息表 | `Customer` | cid / cname / ctel / caddress | 3001 陈晓 13800001234 合肥市蜀山区大学城商业街 |

MyBatis 阶段已经用过店铺表（作业2）和订单表（练习9），这次三张表一起放进 Spring 容器。

## 实现结构

三张表对应课上两个知识点，结构照课堂 User 案例与 Teacher↔Address 关联原样替换：

**① merchant 分层链**（`applicationContext.xml`：component-scan 扫全包）

```
TestAnnotation(main) → MerchantController(@Controller, @Autowired)
                       → MerchantServiceImpl(@Service, @Autowired IMerchantDao)
                       → MerchantDaoImpl(@Repository("merchantDao"))
                         save() 里起容器取 merchant 打印
```

**② orders→customer 注解关联**（`annotation_beans.xml`：component-scan 扫 pojo + 一个 XML 版 customer bean 作对照）

- `Orders` 的字段用 `@Value` 注入，其中引用类型属性 `customer` 用 `@Autowired + @Qualifier("customer")` 注入 —— 与课上 `Teacher.schoolAddress` 的写法完全一致
- `Customer` 用 `@Component("customer")` 显式命名 + `@Scope(value = "singleton")`

## 运行与输出

```bash
mvn test -Dtest=TestAnnotationBeans   # JUnit 2 用例
# TestAnnotation 是 main 方法，IDEA 里直接运行
```

**main 输出**（分层链）：

```
Merchant(mid=1, mname=卡旺卡奶茶店, maddress=合肥市蜀山区长江西路189号)
执行MerchantDaoImpl.save()
执行MerchantServiceImpl.save()
执行MerchantController.save()
```

**testAutoWire 输出**（关联注入）：

```
Orders(oid=1001, ono=WY20260924001, ogoods=黑糖奶茶大杯, oprice=16.0, mid=1, customer=Customer(cid=3001, cname=陈晓, ctel=13800001234, caddress=合肥市蜀山区大学城商业街))
```

## 抄作业的同学可能遇到的坑

1. **component-scan 忘写**：`getBean` 直接 `NoSuchBeanDefinitionException`。注解只是标记，扫不扫描决定生不生效
2. **@Qualifier 的名字和 @Component 的名字对不上**：注入报 `NoSuchBeanDefinitionException`。`@Component("customer")` 起的名，`@Qualifier("customer")` 必须一字不差
3. **@Value 注 Integer/Double**：直接写 `@Value("3001")` 就行，Spring 自动转型，不用手动转
4. **数据里带了中文**：pom 和 IDEA 都要 UTF-8（`-Dfile.encoding=UTF-8`），否则控制台乱码
5. **用的 Spring 7.1.0-M1**（老师课堂指定版本）：里程碑版在 Maven 中央仓库可以直接下，pom 照本仓库抄即可
6. 顺带一提：卡旺卡是合肥的奶茶品牌，大庆没有——所以示例数据店铺在合肥不在大庆
