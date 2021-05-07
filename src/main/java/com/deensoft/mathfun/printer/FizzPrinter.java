package com.deensoft.mathfun.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FizzPrinter {
    public static final String FIZZ = "Fizz";
    private static Logger LOGGER = LoggerFactory.getLogger(FizzPrinter.class);

    public void print(){
        LOGGER.info(FIZZ);
    }
}
