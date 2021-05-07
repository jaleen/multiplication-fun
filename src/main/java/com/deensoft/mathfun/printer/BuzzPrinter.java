package com.deensoft.mathfun.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuzzPrinter {
    public static final String BUZZ = "Buzz";
    private static Logger LOGGER = LoggerFactory.getLogger(BuzzPrinter.class);

    public void print(){
        LOGGER.info(BUZZ);
    }
}
