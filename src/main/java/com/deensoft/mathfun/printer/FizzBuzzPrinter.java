package com.deensoft.mathfun.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FizzBuzzPrinter implements FunPrinter {
    public static final String BUZZ = "FizzBuzz";
    private static Logger LOGGER = LoggerFactory.getLogger(FizzBuzzPrinter.class);

    @Override
    public void print(int num) {
        LOGGER.info(BUZZ);
    }
}
