package com.brian.test;

public class BigCar extends Car {
    private int size;

    public BigCar(int batch, int size) {
        super(batch);
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BigCar) {
            return super.equals(obj) && ((BigCar) obj).size == this.size;
        }

        return super.equals(obj);
    }
}
