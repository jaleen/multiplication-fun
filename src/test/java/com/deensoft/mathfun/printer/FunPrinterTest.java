package com.deensoft.mathfun.printer;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.deensoft.mathfun.util.MemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FunPrinterTest {

    private static final String LOGGER_NAME = "com.deensoft.mathfun";
    private MemoryAppender memoryAppender;

    @Autowired
    private PrinterStrategyContext strategyContext;

    @BeforeEach
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

        short num = 1;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search(String.valueOf(num), Level.INFO).size()).isEqualTo(1);
    }

    @Test
    public void given3ThenPrintFizz() {

        short num = 3;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search("Fizz", Level.INFO).size()).isEqualTo(1);
    }

    @Test
    public void given5ThenPrintBuzz() {
        short num = 5;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);

        assertThat(memoryAppender.search("Buzz", Level.INFO).size()).isEqualTo(1);
    }

    @Test
    public void givenMultipleOf3ThenPrintFizz() {

        short num = 9;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search("Fizz", Level.INFO).size()).isEqualTo(1);
    }

    @Test
    public void givenNegativeNoWhenMultipleOf3ThenPrintFizz() {
        short num = -9;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search("Fizz", Level.INFO).size()).isEqualTo(1);
    }

    @Test
    public void givenANumberWhenNotMultipleOf3ThenDontPrintFizz() {
        short num = 1;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search("Fizz", Level.INFO).size()).isEqualTo(0);
    }

    @Test
    public void givenMultipleOf5ThenPrintBuzz() {
        short num = 25;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search("Buzz", Level.INFO).size()).isEqualTo(1);
    }

    @Test
    public void givenNegativeNoWhenMultipleOf5ThenPrintBuzz() {
        short num = -25;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search("Buzz", Level.INFO).size()).isEqualTo(1);
    }

    @Test
    public void givenANumberWhenNotMultipleOf5ThenDontPrintBuzz() {

        short num = 1;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search("Buzz", Level.INFO).size()).isEqualTo(0);
    }

    @Test
    public void givenMultipleOf3and5ThenPrintFizzBuzz() {

        short num = 15;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search("FizzBuzz", Level.INFO).size()).isEqualTo(1);
    }

    @Test
    public void whenNotMultipleOf3and5ThenDoNotPrintFizzBuzz() {
        short num = 5;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search("FizzBuzz", Level.INFO).size()).isEqualTo(0);
    }

    @AfterEach
    public void cleanUp() {
        memoryAppender.reset();
        memoryAppender.stop();
    }
}