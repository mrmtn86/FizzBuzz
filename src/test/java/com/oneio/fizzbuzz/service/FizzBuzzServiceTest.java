package com.oneio.fizzbuzz.service;

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
    void playShouldReturnOneWhenComputerStartRequestSend()  {


        FizzBuzzNumberTracker fizzBuzzNumberTracker = Mockito.mock(FizzBuzzNumberTracker.class);
        when(fizzBuzzNumberTracker.start()).thenReturn(1);
        FizzBuzzService fizzBuzzService = new FizzBuzzService(fizzBuzzNumberTracker);


        String playResult = fizzBuzzService.play(COMPUTER_START_REQUEST);


        assertThat(playResult).isEqualTo("1");
    }

    @Test
    @DisplayName("play Should Return Two When User Send 1")
    void playShouldReturnOneWhenUserSendOne()   {

        FizzBuzzNumberTracker fizzBuzzNumberTracker = Mockito.mock(FizzBuzzNumberTracker.class);
        when(fizzBuzzNumberTracker.next()).thenReturn(2);
        FizzBuzzService fizzBuzzService = new FizzBuzzService(fizzBuzzNumberTracker);


        String playResult = fizzBuzzService.play("1");


        assertThat(playResult).isEqualTo("2");
    }

    @Test
    @DisplayName("play Should Return Fail Message When User Send Incorrect Answer")
    void playShouldReturnFailMessageWhenUserSendIncorrectAnswer()   {

        FizzBuzzNumberTracker fizzBuzzNumberTracker = Mockito.mock(FizzBuzzNumberTracker.class);
        when(fizzBuzzNumberTracker.next()).thenReturn(3);
        FizzBuzzService fizzBuzzService = new FizzBuzzService(fizzBuzzNumberTracker);


        String playResult = fizzBuzzService.play("5");


        assertThat(playResult).isEqualTo(format(WRONG_ANSWER_MESSAGE, FIZZ));
    }

    @Test
    @DisplayName("play Should Return Correct Answer When User Send Correct Answer")
    void playShouldReturnCorrectAnswerWhenUserSendCorrectAnswer()   {

        FizzBuzzNumberTracker fizzBuzzNumberTracker = Mockito.mock(FizzBuzzNumberTracker.class);
        when(fizzBuzzNumberTracker.next()).thenReturn(6);
        FizzBuzzService fizzBuzzService = new FizzBuzzService(fizzBuzzNumberTracker);


        String playResult = fizzBuzzService.play(BUZZ);


        assertThat(playResult).isEqualTo(format(WRONG_ANSWER_MESSAGE, FIZZ));
    }

    @Test
    void askReturnsValidValuesForMultipleNumbers() {

        FizzBuzzNumberTracker fizzBuzzNumberTracker = Mockito.mock(FizzBuzzNumberTracker.class);
        FizzBuzzService fizzBuzzService =  new FizzBuzzService(fizzBuzzNumberTracker);

        String result = fizzBuzzService.ask("5-5-6-7-15-654-654");

        assertThat(result).isEqualTo("5:Buzz 5:Buzz 6:Fizz 7:7 15:FizzBuzz 654:Fizz 654:Fizz ");
    }
}
