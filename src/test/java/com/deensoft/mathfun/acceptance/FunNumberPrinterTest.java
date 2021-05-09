
package com.deensoft.mathfun.acceptance;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.deensoft.mathfun.printer.FunPrinter;
import com.deensoft.mathfun.printer.PrinterStrategyContext;
import com.deensoft.mathfun.util.MemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class FunNumberPrinterTest {

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
    void given1ThenPrint1() {

        int num = 11;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search(String.valueOf(num), Level.INFO).size()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({
            "0, Fizz",
            "3, Fizz",
            "9, Fizz",
            "-9, Fizz",
            "13, Fizz",
            "5, Buzz",
            "52, Buzz",
            "25, Buzz",
            "-25, Buzz",
            "15, FizzBuzz",
            "51, Buzz",
            "1, 1",
            "2, 2"
    })
    void given3ThenPrintFizz(int num, String output) {

        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search(output, Level.INFO).size()).isEqualTo(1);
    }

    @Test
    void whenNotMultipleOf3and5ThenDoNotPrintFizzBuzz() {
        int num = 5;
        FunPrinter funPrinter = strategyContext.getStrategy(num);
        funPrinter.print(num);
        assertThat(memoryAppender.search("FizzBuzz", Level.INFO).size()).isZero();
    }


    @AfterEach
    public void cleanUp() {
        memoryAppender.reset();
        memoryAppender.stop();
    }
}