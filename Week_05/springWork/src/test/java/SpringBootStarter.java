import io.work02.MainApplicationStarter;
import io.work02.MyProperties;
import io.work02.School;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * @author Leeyj
 * @date 2021/2/18 11:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplicationStarter.class)
@WebAppConfiguration
public class SpringBootStarter {

    @Autowired
    private School school;

    @Test
    public void testStarter() {
        System.out.println(school.generaterId());
    }

}
