package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNothing {

    @Test
    public void myFirstTest() {
        Assert.assertEquals(1, 1, "[ERR] OMG, 1 is NOT 1 any more!");
    }
}
