package com.deensoft.mathfun.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FizzBuzzPrinter implements FunPrinter {
    public static final String BUZZ = "FizzBuzz";
    private static Logger LOGGER = LoggerFactory.getLogger(FizzBuzzPrinter.class);

    @Override
    public void print(short num) {
        if (num % 5 == 0 && num % 3 == 0)
            LOGGER.info(BUZZ);
    }
}
