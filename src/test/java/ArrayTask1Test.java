import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class ArrayTask1Test {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 4, 4, 4, 1, 4, 1}, true},
                {new int[]{9, 3, 4, 5, 5, 2, 5, 1}, false},
                {new int[]{2,2,3,4,5,6,1,3},false},
                {new int[]{1, 4, 8, 7}, false}
        });
    }

    private int[] in;
    private boolean out;

    public ArrayTask1Test(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private ArrayTask1 task1;

    @Before
    public void startTest() {
        task1 = new ArrayTask1();
    }

    @Test
    public void testCheckArrayForOneAndFour() {
        Assert.assertEquals(ArrayTask1.checkArrayForOneAndFour(in), out);
    }
}