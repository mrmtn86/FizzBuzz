package com.oneio.fizzbuzz.service;

import com.oneio.fizzbuzz.exception.FileOperationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.oneio.fizzbuzz.service.FizzBuzzService.COMPUTER_START_REQUEST;
import static com.oneio.fizzbuzz.service.FizzBuzzService.WRONG_ANSWER_MESSAGE;
import static com.oneio.fizzbuzz.util.FizzBuzzGuru.BUZZ;
import static com.oneio.fizzbuzz.util.FizzBuzzGuru.FIZZ;
import static java.text.MessageFormat.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class FizzBuzzServiceTest {

    @Test
    @DisplayName("play Should Return One When Computer Start Request Send")
    void playShouldReturnOneWhenComputerStartRequestSend() throws FileOperationException {


        FizzBuzzNumberTracker fizzBuzzNumberTracker = Mockito.mock(FizzBuzzNumberTracker.class);
        when(fizzBuzzNumberTracker.start()).thenReturn(1);
        FizzBuzzService fizzBuzzService = new FizzBuzzService(fizzBuzzNumberTracker);


        String playResult = fizzBuzzService.play(COMPUTER_START_REQUEST);


        assertThat(playResult).isEqualTo("1");
    }

    @Test
    @DisplayName("play Should Return Two When User Send 1")
    void playShouldReturnOneWhenUserSendOne() throws FileOperationException {

        FizzBuzzNumberTracker fizzBuzzNumberTracker = Mockito.mock(FizzBuzzNumberTracker.class);
        when(fizzBuzzNumberTracker.next()).thenReturn(2);
        FizzBuzzService fizzBuzzService = new FizzBuzzService(fizzBuzzNumberTracker);


        String playResult = fizzBuzzService.play("1");


        assertThat(playResult).isEqualTo("2");
    }

    @Test
    @DisplayName("play Should Return Fail Message When User Send Incorrect Answer")
    void playShouldReturnFailMessageWhenUserSendIncorrectAnswer() throws FileOperationException {

        FizzBuzzNumberTracker fizzBuzzNumberTracker = Mockito.mock(FizzBuzzNumberTracker.class);
        when(fizzBuzzNumberTracker.next()).thenReturn(3);
        FizzBuzzService fizzBuzzService = new FizzBuzzService(fizzBuzzNumberTracker);


        String playResult = fizzBuzzService.play("5");


        assertThat(playResult).isEqualTo(format(WRONG_ANSWER_MESSAGE, FIZZ));
    }

    @Test
    @DisplayName("play Should Return Correct Answer When User Send Correct Answer")
    void playShouldReturnCorrectAnswerWhenUserSendCorrectAnswer() throws FileOperationException {

        FizzBuzzNumberTracker fizzBuzzNumberTracker = Mockito.mock(FizzBuzzNumberTracker.class);
        when(fizzBuzzNumberTracker.next()).thenReturn(6);
        FizzBuzzService fizzBuzzService = new FizzBuzzService(fizzBuzzNumberTracker);


        String playResult = fizzBuzzService.play(BUZZ);


        assertThat(playResult).isEqualTo(format(WRONG_ANSWER_MESSAGE, FIZZ));
    }
}
