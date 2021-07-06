package com.practice.abstraction;

public class Circle extends Figure {
    double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
}
