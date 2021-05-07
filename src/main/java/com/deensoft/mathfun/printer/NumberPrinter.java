package com.deensoft.mathfun.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberPrinter implements FunPrinter {
    private static Logger LOGGER = LoggerFactory.getLogger(BuzzPrinter.class);

    public void print(short num){
        LOGGER.info(String.valueOf(num));
    }
}
