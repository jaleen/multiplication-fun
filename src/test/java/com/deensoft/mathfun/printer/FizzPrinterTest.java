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

public class FizzPrinterTest {

    private static final String LOGGER_NAME = "com.deensoft.mathfun";
    private static final String MSG = "Fizz";
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
    public void test() {
        FizzPrinter fizzPrinter = new FizzPrinter();

        short num = 0;
        fizzPrinter.print(num);
        assertThat(memoryAppender.search(MSG, Level.INFO).size()).isEqualTo(1);
    }

    @After
    public void cleanUp() {
        memoryAppender.reset();
        memoryAppender.stop();
    }
}