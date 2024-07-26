package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeter() {
        var t = new Triangle(6.0, 7.0, 8.0);
        double result = t.perimeter();
        Assertions.assertEquals(21.0, result);
    }

    @Test
    void canCalculateArea() {
        var t = new Triangle(6.0, 7.0, 8.0);
        double result = t.area();
        Assertions.assertEquals(20.0, result);
    }
}
