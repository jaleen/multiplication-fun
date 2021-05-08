package com.deensoft.mathfun;

import com.deensoft.mathfun.printer.PrinterStrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Service
public class MultiplicationGame {

    @Autowired
    private PrinterStrategyContext context;

    public void play(int startNum, int finishNum){
        IntStream.range(startNum, finishNum).forEach(num-> context.getStrategy(num).print(num));
    }

    @PostConstruct
    public void init() {
        play(1,100);
    }
}
