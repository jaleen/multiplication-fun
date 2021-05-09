package com.deensoft.mathfun.printer;

import org.springframework.beans.factory.annotation.Autowired;
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

        if (isFizz(num) && isBuzz(num)) {
            return fizzBuzzPrinter;
        } else if (isFizz(num)) {
            return fizzPrinter;
        } else if (isBuzz(num)) {
            return buzzPrinter;
        }
        return numberPrinter;
    }

    private boolean isBuzz(int num) {
        return num % 5 == 0 || String.valueOf(num).contains("5");
    }

    private boolean isFizz(int num) {
        return num % 3 == 0 || String.valueOf(num).contains("3");
    }
}
