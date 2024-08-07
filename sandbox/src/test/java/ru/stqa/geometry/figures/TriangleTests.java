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
        var t = new Triangle(3.0, 4.0, 5.0);
        double result = t.area();
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void  cannotCreateTriangleWithNegativeSideOne() {
        try {
            new Triangle(-3.0, 4.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //Ok
        }
    }

    @Test
    void  cannotCreateTriangleWithNegativeSideOTwo() {
        try {
            new Triangle(3.0, -4.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //Ok
        }
    }

    @Test
    void  cannotCreateTriangleWithNegativeSideOThree() {
        try {
            new Triangle(3.0, 4.0, -5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //Ok
        }
    }

    @Test
    void twoSidesSumBiggerThanThirdSide() {
        try {
            new Triangle(3.0, 4.0, 8.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //Ok
        }
    }

    @Test
    void testEquality1() {
        var t1 = new Triangle(3.0, 4.0, 5.0);
        var t2 = new Triangle(4.0, 5.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality2() {
        var t1 = new Triangle(3.0, 4.0, 5.0);
        var t2 = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality3() {
        var t1 = new Triangle(3.0, 4.0, 5.0);
        var t2 = new Triangle(5.0, 3.0, 4.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality4() {
        var t1 = new Triangle(3.0, 4.0, 5.0);
        var t2 = new Triangle(4.0, 3.0, 5.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality5() {
        var t1 = new Triangle(3.0, 4.0, 5.0);
        var t2 = new Triangle(5.0, 4.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality6() {
        var t1 = new Triangle(3.0, 4.0, 5.0);
        var t2 = new Triangle(3.0, 5.0, 4.0);
        Assertions.assertEquals(t1, t2);
    }
}
