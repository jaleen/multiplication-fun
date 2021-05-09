package com.deensoft.mathfun.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FizzPrinter implements FunPrinter {
    public static final String FIZZ = "Fizz";
    private static Logger logger = LoggerFactory.getLogger(FizzPrinter.class);

    @Override
    public void print(int num) {
        logger.info(FIZZ);
    }
}
