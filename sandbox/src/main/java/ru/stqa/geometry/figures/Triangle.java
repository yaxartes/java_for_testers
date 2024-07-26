package ru.stqa.geometry.figures;

public record Triangle(double a, double b, double c) {

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public double area() {
        double p = this.perimeter() / 2;
        double r = Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
        return Math.round(r);
    }
}
