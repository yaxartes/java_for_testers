package ru.stqa.geometry.figures;

public record Triangle(double a, double b, double c) {

    public Triangle {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("The sum of any two sides of a triangle should be greater than the third side");
        }
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public double area() {
        double p = this.perimeter() / 2;
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }
}
