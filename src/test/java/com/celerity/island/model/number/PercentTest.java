package com.celerity.island.model.number;

import com.celerity.island.model.number.exception.LessThanZeroValueException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PercentTest {

    private Percent percent;

    @Before
    public void setUp() {
        percent = new Percent();
    }

    @Test
    public void testDefault() {
        Assert.assertThat(percent, CoreMatchers.notNullValue());
        Assert.assertThat(percent.getValue(), CoreMatchers.equalTo(100));
    }

    @Test
    public void testIncreaseGreaterThan100() {
        percent.increase(50);

        Assert.assertThat(percent.getValue(), CoreMatchers.equalTo(100));
    }

    @Test
    public void testIncrease() throws LessThanZeroValueException {
        percent.decrease(50);
        percent.increase(25);

        Assert.assertThat(percent.getValue(), CoreMatchers.equalTo(75));
    }
}