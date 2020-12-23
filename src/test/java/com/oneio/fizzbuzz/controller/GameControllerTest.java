package com.oneio.fizzbuzz.controller;

import static com.oneio.fizzbuzz.service.FizzBuzzService.COMPUTER_START_REQUEST;
import static com.oneio.fizzbuzz.service.FizzBuzzService.WRONG_ANSWER_MESSAGE;
import static java.text.MessageFormat.format;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.oneio.fizzbuzz.util.FizzBuzzGuru;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest()
@AutoConfigureMockMvc
class GameControllerTest {

    public static final String V_1_FIZZ_BUZZ = "/v1/fizz-buzz/";
    public static final String MOVE = "move";
    public static final String ANSWER = "answer";
    @Autowired
    private MockMvc mockMvc;

    @Test
    void playShouldReturnNewGameStartedByComputer() throws Exception {

        mockMvc.perform(get(V_1_FIZZ_BUZZ).param(MOVE, COMPUTER_START_REQUEST))
                .andDo(print())
                .andExpect(jsonPath(ANSWER, equalTo("1")));

    }

    @Test
    void playShouldReturnNewGameStartedByUser() throws Exception {

        mockMvc.perform(get(V_1_FIZZ_BUZZ).param(MOVE, "1"))
                .andDo(print())
                .andExpect(jsonPath(ANSWER, equalTo("2")));
    }

    @Test
    void playShouldReturnCorrectAnswerFoOngoingGame() throws Exception {

        mockMvc.perform(get(V_1_FIZZ_BUZZ).param(MOVE, "1"));
        mockMvc.perform(get(V_1_FIZZ_BUZZ).param(MOVE, FizzBuzzGuru.FIZZ))
                .andDo(print())
                .andExpect(jsonPath(ANSWER, equalTo("4")));
    }

    @Test
    void playShouldReturnInformationWhenUserSendsWrongAnswer() throws Exception {

        mockMvc.perform(get(V_1_FIZZ_BUZZ).param(MOVE, "1"));
        mockMvc.perform(get(V_1_FIZZ_BUZZ).param(MOVE, "2"))
                .andDo(print())
                .andExpect(jsonPath(ANSWER, equalTo(format(WRONG_ANSWER_MESSAGE, FizzBuzzGuru.FIZZ))));
    }

    @Test
    void correctAnswerShouldReturnCorrectAnswerForRequestedNumber() throws Exception {
        mockMvc.perform(get(V_1_FIZZ_BUZZ+"/ask/15"))
                .andDo(print())
                .andExpect(jsonPath(ANSWER, equalTo(FizzBuzzGuru.FIZZBUZZ)));
    }
}
