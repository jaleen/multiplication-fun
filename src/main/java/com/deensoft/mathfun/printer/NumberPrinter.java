package com.deensoft.mathfun.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NumberPrinter implements FunPrinter {
    private static Logger logger = LoggerFactory.getLogger(NumberPrinter.class);

    public void print(int num) {
        logger.info("{}", num);
    }
}
