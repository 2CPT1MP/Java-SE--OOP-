import org.junit.Before;
import org.junit.Test;
public class OptionProcessorTest {
    static OptionProcessor processor;
    @Before
    public void setUp() {
        processor = new OptionProcessor();
    }




    @Test
    public void testAddOption() {
        processor.addOption("Discrete Math");
    }


    /*@Test
    public void testGetOptionFailure() {
        String result = processor.getOption();
        assert result != null;
        System.out.println(result);
        assert result.equalsIgnoreCase("No options are available");
    }
    */

    @Test
    public void testGetOption() {
        String result = processor.getOption();
        assert result != null;
        System.out.println(result);
        assert result.equalsIgnoreCase("The first Option");
    }

    /*@Test
    public void testRandomizer() {
        assert (processor.randomizeOption() >= 0) && (processor.randomizeOption() < processor.options.length) ;
    }
    */



}
