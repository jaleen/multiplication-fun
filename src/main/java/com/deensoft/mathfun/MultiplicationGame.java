package com.deensoft.mathfun;

import com.deensoft.mathfun.printer.PrinterStrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Service
public class MultiplicationGame {

    @Value("${startNum}")
    private int startNum;

    @Value("${finishNum}")
    private int finishNum;

    @Autowired
    private PrinterStrategyContext context;

    public void play(int startNum, int finishNum){
        IntStream.range(startNum, finishNum+1).forEach(num-> context.getStrategy(num).print(num));
    }

    @PostConstruct
    public void init() {
        play(startNum,finishNum);
    }
}
