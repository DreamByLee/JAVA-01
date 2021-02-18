import io.work01.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AutoLoadConfig.class)  //自动装配
@ContextConfiguration(classes = OpenLoadConfig.class)    //显式装配
public class SpringLoadBeanTest {

    /**
     * xml装配
     */
    @Test
    public void testLoad() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Animal animal = (Animal) context.getBean("animal");
        System.out.println(animal);
        animal.getCat().hello();
        animal.getDog().hello();
    }

    /**
     * 自动装配（打开上面的自动装配注释并注释显式装配）
     */
    @Autowired
    private Dog dog;
    @Test
    public void testAutoLoad() {
        dog.hello();
    }

    /**
     * 显式装配
     */
    @Autowired
    private Cat cat;
    @Test
    public void testOpenLoad() {
        cat.hello();
    }


}
