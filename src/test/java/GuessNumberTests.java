import com.test.tasks.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GuessNumberTests {
    Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void randWithoutParameters() {
        int number = model.rand();
        System.out.println(number);
        Assert.assertTrue(number >= 0 && number <= 20);
    }

    @Test (expected = IllegalArgumentException.class)
    public void randWithParameters() throws IllegalArgumentException {
        model.rand(8,7);
    }

    @Test
    public void typeSomeString() {

    }
}
