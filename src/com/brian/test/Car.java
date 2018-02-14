package com.brian.test;

public class Car {
    private int batch;;
    public Car(int batch) {
        this.batch = batch;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            return ((Car) obj).batch == this.batch;
        }

        return false;
    }
}
