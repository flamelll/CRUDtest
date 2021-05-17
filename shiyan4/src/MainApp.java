import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");//在这里我们使用框架API ClassPathXmlApplicationContext() 应用程序上下文。这个API加载 applicationContext 的配置文件，并最终基于所提供的API，它需要创建并初始化所有的对象。在配置文件中提到的beans 类。

        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");//用来使用创建的上下文的 getBean() 方法获得所需的bean。此方法使用 bean 的 id 返回，最终可以创建实际对象的通用对象。一旦有了对象，就可以使用这个对象调用任何类方法。

        obj.getMessage();
    }
}