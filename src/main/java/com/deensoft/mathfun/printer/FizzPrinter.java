package com.deensoft.mathfun.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FizzPrinter implements FunPrinter {
    public static final String FIZZ = "Fizz";
    private static Logger LOGGER = LoggerFactory.getLogger(FizzPrinter.class);

    @Override
    public void print(short num) {
        if (num % 3 == 0)
            LOGGER.info(FIZZ);
    }
}
