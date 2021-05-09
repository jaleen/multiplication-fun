package com.deensoft.mathfun.printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrinterStrategyContext {

    private BuzzPrinter buzzPrinter;
    private FizzBuzzPrinter fizzBuzzPrinter;
    private FizzPrinter fizzPrinter;
    private NumberPrinter numberPrinter;

    @Autowired
    public PrinterStrategyContext(BuzzPrinter buzzPrinter, FizzBuzzPrinter fizzBuzzPrinter, FizzPrinter fizzPrinter, NumberPrinter numberPrinter) {
        this.buzzPrinter = buzzPrinter;
        this.fizzBuzzPrinter = fizzBuzzPrinter;
        this.fizzPrinter = fizzPrinter;
        this.numberPrinter = numberPrinter;
    }


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
