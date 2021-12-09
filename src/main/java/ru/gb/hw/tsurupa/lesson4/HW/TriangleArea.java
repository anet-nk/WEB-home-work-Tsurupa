package ru.gb.hw.tsurupa.lesson4.HW;

public class TriangleArea {

    public static double triangleArea(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException("The sides must be positive!");
        if (a + b <= c || a + c <= b || c + b <= a)
            throw new IllegalArgumentException("The triangle with such countries does not exist");
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        double scale = Math.pow(10, 2);
        return Math.round(s * scale) / scale;
        }

    }


