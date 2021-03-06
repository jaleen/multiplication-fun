package com.deensoft.mathfun.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BuzzPrinter implements FunPrinter {
    public static final String BUZZ = "Buzz";
    private static Logger logger = LoggerFactory.getLogger(BuzzPrinter.class);

    @Override
    public void print(int num) {

            logger.info(BUZZ);
    }
}
