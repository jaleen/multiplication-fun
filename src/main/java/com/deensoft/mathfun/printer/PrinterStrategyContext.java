package com.deensoft.mathfun.printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PrinterStrategyContext {

    @Autowired
    private BuzzPrinter buzzPrinter;
    @Autowired
    private FizzBuzzPrinter fizzBuzzPrinter;
    @Autowired
    private FizzPrinter fizzPrinter;
    @Autowired
    private NumberPrinter numberPrinter;

    public FunPrinter getStrategy(int num) {

        if (num % 15 == 0) {
            return fizzBuzzPrinter;
        } else if (num % 3 == 0 || String.valueOf(num).contains("3")) {
            return fizzPrinter;
        } else if (num % 5 == 0 || String.valueOf(num).contains("5") ) {
            return buzzPrinter;
        }
        return numberPrinter;
    }
}
