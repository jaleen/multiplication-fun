package com.deensoft.mathfun;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.deensoft.mathfun.printer.PrinterStrategyContext;
import com.deensoft.mathfun.util.MemoryAppender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class MultiplicationGameTest {
    private static final String LOGGER_NAME = "com.deensoft.mathfun";
    private MemoryAppender memoryAppender;

    @Autowired
    private PrinterStrategyContext strategyContext;
    @Autowired
    private MultiplicationGame game;

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
    void givenTwoNumsWhenPlayThenPrint() {

        int finishNum = 100;
        int startNum = 1;
        game.play(startNum, finishNum);

        List<String> expectedOutput = IntStream.range(1, 100).mapToObj(
                num -> (isFizz(num) && isBuzz(num) ? "FizzBuzz" : (isFizz(num) ? "Fizz" : (isBuzz(num) ? "Buzz" : String.valueOf(num)))))
                .collect(Collectors.toList());
        List<String> actual = memoryAppender.list.stream().map(ILoggingEvent::getMessage).collect(Collectors.toList());
        assertThat(actual).isEqualTo(expectedOutput);
    }

    private boolean isBuzz(int num) {
        return num % 5 == 0 || String.valueOf(num).contains("5");
    }

    private boolean isFizz(int num) {
        return num % 3 == 0 || String.valueOf(num).contains("3");
    }

}