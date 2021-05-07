package com.deensoft.mathfun.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuzzPrinter implements FunPrinter {
    public static final String BUZZ = "Buzz";
    private static Logger LOGGER = LoggerFactory.getLogger(BuzzPrinter.class);

    @Override
    public void print(short num) {
        if (num % 5 == 0)
            LOGGER.info(BUZZ);
    }
}
