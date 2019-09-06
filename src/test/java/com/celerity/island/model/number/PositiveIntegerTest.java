package com.celerity.island.model.number;

import com.celerity.island.model.number.exception.LessThanZeroValueException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PositiveIntegerTest {

    private PositiveInteger positiveInteger;


    @Before
    public void setUp() throws Exception {
        positiveInteger = new PositiveInteger(100);
    }
    
    @Test
    public void testDecrease() throws LessThanZeroValueException {
        positiveInteger.decrease(50);

        Assert.assertThat(positiveInteger.getValue(), CoreMatchers.equalTo(50));
    }

    @Test(expected = LessThanZeroValueException.class)
    public void testDecreaseToZeroValue() throws LessThanZeroValueException {
        positiveInteger.decrease(100);

        Assert.assertThat(positiveInteger.getValue(), CoreMatchers.equalTo(0));
    }

    @Test
    public void testIncrease() {
        positiveInteger.increase(200);

        Assert.assertThat(positiveInteger.getValue(), CoreMatchers.equalTo(300));
    }
}