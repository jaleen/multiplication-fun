package com.deensoft.mathfun.printer;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.deensoft.mathfun.util.MemoryAppender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FunPrinterTest {

    private static final String LOGGER_NAME = "com.deensoft.mathfun";
    private MemoryAppender memoryAppender;

    @Before
    public void setup() {
        Logger logger = (Logger) LoggerFactory.getLogger(LOGGER_NAME);
        memoryAppender = new MemoryAppender();
        memoryAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
        logger.setLevel(Level.DEBUG);
        logger.addAppender(memoryAppender);
        memoryAppender.start();

    }
    @Test
    public void given1ThenPrint1() {
        FunPrinter funPrinter = new NumberPrinter();

        short num = 1;
        funPrinter.print(num);
        assertThat(memoryAppender.search( String.valueOf(num), Level.INFO).size()).isEqualTo(1);
    }
    @Test
    public void given3ThenPrintFizz() {
        FunPrinter funPrinter = new FizzPrinter();

        short num = 3;
        funPrinter.print(num);
        assertThat(memoryAppender.search( "Fizz", Level.INFO).size()).isEqualTo(1);
    }

    @Test
    public void given5ThenPrintBuzz() {
        FunPrinter funPrinter = new BuzzPrinter();

        short num = 5;
        funPrinter.print(num);
        assertThat(memoryAppender.search( "Buzz", Level.INFO).size()).isEqualTo(1);
    }
    @Test
    public void givenMultipleOf3ThenPrintFizz() {
        FunPrinter funPrinter = new FizzPrinter();

        short num = 9;
        funPrinter.print(num);
        assertThat(memoryAppender.search( "Fizz", Level.INFO).size()).isEqualTo(1);
    }
    @Test
    public void givenNegativeNoWhenMultipleOf3ThenPrintFizz() {
        FunPrinter funPrinter = new FizzPrinter();

        short num = -9;
        funPrinter.print(num);
        assertThat(memoryAppender.search( "Fizz", Level.INFO).size()).isEqualTo(1);
    }
    @Test
    public void givenANumberWhenNotMultipleOf3ThenDontPrintFizz() {
        FunPrinter funPrinter = new FizzPrinter();

        short num = 1;
        funPrinter.print(num);
        assertThat(memoryAppender.search( "Fizz", Level.INFO).size()).isEqualTo(0);
    }

    @Test
    public void givenMultipleOf5ThenPrintBuzz() {
        FunPrinter funPrinter = new BuzzPrinter();

        short num = 25;
        funPrinter.print(num);
        assertThat(memoryAppender.search( "Buzz", Level.INFO).size()).isEqualTo(1);
    }
    @Test
    public void givenNegativeNoWhenMultipleOf5ThenPrintBuzz() {
        FunPrinter funPrinter = new BuzzPrinter();

        short num = -25;
        funPrinter.print(num);
        assertThat(memoryAppender.search( "Buzz", Level.INFO).size()).isEqualTo(1);
    }
    @Test
    public void givenANumberWhenNotMultipleOf5ThenDontPrintBuzz() {
        FunPrinter funPrinter = new BuzzPrinter();

        short num = 1;
        funPrinter.print(num);
        assertThat(memoryAppender.search( "Buzz", Level.INFO).size()).isEqualTo(0);
    }
    @After
    public void cleanUp() {
        memoryAppender.reset();
        memoryAppender.stop();
    }
}