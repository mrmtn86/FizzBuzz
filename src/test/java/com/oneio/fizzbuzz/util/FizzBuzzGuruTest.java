package com.oneio.fizzbuzz.util;

import org.junit.jupiter.api.Test;

import static com.oneio.fizzbuzz.util.FizzBuzzGuru.*;
import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzGuruTest {

    @Test
    void getAnswerShouldReturnFizzFor3() {
        String answer = FizzBuzzGuru.getAnswer(3);

        assertThat(answer).isEqualTo(FIZZ);
    }

    @Test
    void getAnswerShouldReturnBuzzFor5() {
        String answer = FizzBuzzGuru.getAnswer(5);

        assertThat(answer).isEqualTo(BUZZ);
    }

    @Test
    void getAnswerShouldReturnFizzBuzzFor15() {
        String answer = FizzBuzzGuru.getAnswer(15);

        assertThat(answer).isEqualTo(FIZZBUZZ);
    }

    @Test
    void getAnswerShouldReturnNumberFor11() {
        String answer = FizzBuzzGuru.getAnswer(11);

        assertThat(answer).isEqualTo("11");
    }
}
