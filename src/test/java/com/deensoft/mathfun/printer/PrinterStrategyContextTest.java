package com.deensoft.mathfun.printer;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

@RunWith(SpringRunner.class)
public class PrinterStrategyContextTest {

    @MockBean
    private BuzzPrinter buzzPrinter;
    @MockBean
    private FizzBuzzPrinter fizzBuzzPrinter;
    @MockBean
    public FizzPrinter fizzPrinter;
    @MockBean
    public NumberPrinter numberPrinter;

    private PrinterStrategyContext context;


    @Before
    public void setup() {
        context = new PrinterStrategyContext(buzzPrinter, fizzBuzzPrinter, fizzPrinter, numberPrinter);
    }

    @Test
    public void when1ThenShouldReturnNumStrategy() {
        FunPrinter printer = context.getStrategy(1);
        assertThat(printer, instanceOf(NumberPrinter.class));
    }

    @Test
    public void when3ThenShouldReturnFizzStrategy() {
        FunPrinter printer = context.getStrategy(3);
        assertThat(printer, instanceOf(FizzPrinter.class));
    }

    @Test
    public void whenContains3ThenShouldReturnFizzStrategy() {
        FunPrinter printer = context.getStrategy(13);
        assertThat(printer, instanceOf(FizzPrinter.class));
    }

    @Test
    public void when5ThenShouldReturnBuzzStrategy() {
        FunPrinter printer = context.getStrategy(5);
        assertThat(printer, instanceOf(BuzzPrinter.class));
    }

    @Test
    public void whenContains5ThenShouldReturnBuzzStrategy() {
        FunPrinter printer = context.getStrategy(52);
        assertThat(printer, instanceOf(BuzzPrinter.class));
    }

    @Test
    public void whenMeetsBothCriteriaThenShouldReturnFizzBuzzStrategy() {
        FunPrinter printer = context.getStrategy(53);
        assertThat(printer, instanceOf(FizzBuzzPrinter.class));
    }
}