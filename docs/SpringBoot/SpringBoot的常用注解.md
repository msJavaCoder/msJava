# SpringBoot的常用注解

>**注解用来定义一个类、属性或方法，方便程序能够被编译处理。它也相当于一个说明文件。告诉程序被某个注解标注的类或属性是什么，要怎么处理。注解可以用在标注包、类、方法和变量。**

## 1. 类上常使用的注解

|         注解          |            使用位置            |                             说明                             |
| :-------------------: | :----------------------------: | :----------------------------------------------------------: |
|    @RestController    |             类名上             | @RestController=@Controller +  @RequestBody    前后端分离情况下，用于返回JSON、XML等格式数据 |
|      @Controller      |             类名上             | 声明当前类是一个控制器层，相当于MVC开发模式中的 C（控制器）  |
|       @Service        |             类名上             |  声明当前类是一个业务处理类，用于标注服务层，处理业务逻辑类  |
|      @Reporitory      |             类名上             |                      用于标注数据访问层                      |
|      @Component       |             类名上             | 通用的注解，可标注任意类为 `Spring` 组件。如果一个 Bean 不知道属于哪个层，可以使用`@Component` 注解标注。 |
|    @Configuration     |             类名上             | 一般用来声明配置类，可以使用 `@Component`注解替代，不过使用`Configuration`注解声明配置类更加语义化 |
|       @Resource       | 类名上、属性上或构造函数参数上 |     和@Autowired都可以用来装配Bean，默认是byType自动注入     |
|      @Autowired       | 类名上、属性上或构造函数参数上 | 自动导入对象到类中，被注入进的类同样要被 Spring 容器管理，默认是byName自动注入 |
|    @RequestMapping    |         类名或者方法上         |                     用来处理请求地址映射                     |
|    @Transactional     |         类名或者方法上         |       在要开启事务的方法上使用`@Transactional`注解即可       |
|      @Qualifier       |          类名或属性上          |  常与@Autowired一起使用，用于标注哪一个实现类才是需要注入的  |
| @JsonIgnoreProperties |             类名上             |              用于过滤掉特定字段不返回或者不解析              |
|      @Transient       |             属性上             | 声明不需要与数据库映射的字段，在保存的时候不需要保存进数据库，虚拟字段 |

## 2. 方法上常使用的注解

|     注解      |  使用位置  |                             说明                             |
| :-----------: | :--------: | :----------------------------------------------------------: |
|     @Bean     |   方法上   |                声明一个Bean并交给Spring管理。                |
| @ReponseBody  |   方法上   | 将方法返回的对象转换为JSON或XML格式后，写入Response对象的body数据区 |
| @RequestBody  | 方法参数前 |          简而言之，就是将JSON 字符串转换为 Java对象          |
| @PathVariable | 方法参数前 |                 将URL获取的参数映射到方法上                  |
|      ···      |            |                                                              |

## 3. 其他常使用的注解

|           注解           |    使用位置    |                             说明                             |
| :----------------------: | :------------: | :----------------------------------------------------------: |
| @EnableAutoConfiguration | 入口类、类名上 |                         开启自动配置                         |
|  @SpringBootApplication  | 入口类、类名上 | 启动入口类Application(@SpringBootApplication看作是 @Configuration、@EnableAutoConfiguration、@ComponentScan 注解的集合。) |
|    @EnableScheduling     | 入口类、类名上 |              用来开启计划任务，如定时执行的任务              |
|       @EnableAsync       | 入口类、类名上 |                       开启异步注解功能                       |
|      @ComponentScan      | 入口类、类名上 |            用来扫描组件，看自动发现和装配一些Bean            |
|          @Aspec          | 入口类、类名上 |         标注切面，可以用来配置事务、日志、权限验证等         |
|    @ControllerAdvice     |     类名上     |          包含@Component,可以被扫描到，统一处理异常           |
|    @ExceptionHandler     |     方法上     |                 表示遇到这个异常就执行该方法                 |
|          @Value          |     属性上     |                    用于获取配置文件中的值                    |
|           ···            |                |                                                              |

## 4. 总结

​	当然SpringBoot提供给我们开发人员的注解非常之多，上文中只是总结了SpringBoot开发过程中常用的一些注解，以及简述了其注解的作用或用途。