package com.deensoft.mathfun.printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrinterStrategyContext {

    @Autowired
    private BuzzPrinter buzzPrinter;
    @Autowired
    private FizzBuzzPrinter fizzBuzzPrinter;
    @Autowired
    private FizzPrinter fizzPrinter;
    @Autowired
    private NumberPrinter numberPrinter;

    public FunPrinter getStrategy(short num) {

        if (num % 15 == 0) {
            return fizzBuzzPrinter;
        } else if (num % 3 == 0) {
            return fizzPrinter;
        } else if (num % 5 == 0) {
            return buzzPrinter;
        }
        return numberPrinter;
    }
}
