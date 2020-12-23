package read.bar.code.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class ComputePurchaseTotalTest {

    @Test
    public void zeroItems() {
        Assert.assertEquals(Integer.valueOf(0), Sale.computePurchaseTotal(Collections.emptyList()));
    }

    @Test
    public void oneItems() {
        Assert.assertEquals(Integer.valueOf(12), Sale.computePurchaseTotal(Collections.singletonList(12)));
    }

    @Test
    public void severalItems() {
        Assert.assertEquals(Integer.valueOf(25), Sale.computePurchaseTotal(Arrays.asList(12, 10, 3)));
    }
}
