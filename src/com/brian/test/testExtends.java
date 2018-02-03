package com.brian.test;

class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f) {
        System.out.println("doh(float)");
        return 0.0f;
    }
}

class Mile {}


class Bart extends Homer {
    void doh(Mile mile) {
        System.out.println("doh(int)");
    }
}

class Lisa extends Homer {
    @Override
    char doh(char c) {
        System.out.println("override");
        return 'b';
    }
}
public class testExtends {
    public static void main(String[] args) {
        Lisa lisa = new Lisa();
        lisa.doh('k');
        Shape s = new Circle();
        s.draw();
        s.erase();
        s.print();
        Shape s1 = new Square();
        s1.draw();
        s1.erase();
        s1.print();
}
}

class Shape {
    void draw() {}
    void erase() {}
    void print() {
        System.out.println("base print");
    }
    void adjust(Shape[] shapes) {
        for (Shape shape : shapes) {
            shape.print();
        }
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("circle draw");
    }
    void erase() {
        System.out.println("circle erase");
    }
    void print() {
        System.out.println("circle print");
    }
}

class Square extends Shape {
    void draw() {
        System.out.println("Square draw");
    }
    void erase() {
        System.out.println("Square erase");
    }
//    void print() {
//        System.out.println("circle print");
//    }
}