package com.oneio.fizzbuzz.util;

public class FizzBuzzGuru {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = FIZZ + BUZZ;

    public static String getAnswer(int number) {

        if (number % 15 == 0) {
            return FIZZBUZZ;
        }
        if (number % 3 == 0) {
            return FIZZ;
        }
        if (number % 5 == 0) {
            return BUZZ;
        }
        return String.valueOf(number);
    }

}
