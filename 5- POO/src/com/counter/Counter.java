package com.counter;

public class Counter {
    private int actualValue;

    public Counter(Counter counter){
        this.actualValue = counter.actualValue;
    }

    public void increment(){
        this.actualValue ++;
    }

    public void decrement(){
        this.actualValue --;
    }

    public int getActualValue() {
        return actualValue;
    }

}
