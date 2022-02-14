package com.company;

class IncrementerImpl implements Incrementer {
    private volatile int number = 0;
    private int maximum = Integer.MAX_VALUE;

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public synchronized void incrementNumber() {
        number = getNumber() + 1;
        if (number == maximum) {
            number = 0;
        }
    }

    @Override
    public synchronized void setMaximumValue(int maximumValue) {
        if (maximumValue < 0) {
            throw new IllegalArgumentException();
        } else if (number > maximumValue) {
            number = 0;
        } else {
            maximum = maximumValue;
        }
    }
}
