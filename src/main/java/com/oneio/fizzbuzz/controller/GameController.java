package com.oneio.fizzbuzz.controller;

import com.oneio.fizzbuzz.exception.FileOperationException;
import com.oneio.fizzbuzz.model.TurnResultDto;
import com.oneio.fizzbuzz.service.FizzBuzzService;
import com.oneio.fizzbuzz.util.FizzBuzzGuru;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@RestController
@RequestMapping("/v1/fizz-buzz")
@Api(tags = "Fizz Buzz Game Api")
@Validated
public class GameController {

    private final FizzBuzzService fizzBuzzService;

    public GameController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @Operation(summary = "You need only this operation to play Fizz Buzz. If you send correct answer then it returns it's answer." +
            " If you send a wrong answer it returns what was the correct answer")
    @Parameter(name = "move", description = "If you want to start a new game send '1'. " +
            "If you want computer to start the to a new game send 'youStart' , " +
            "then you can continue to playing by sending your next answer")
    @GetMapping
    public ResponseEntity<TurnResultDto> play(@RequestParam
                                              @NotNull(message = "move can not be null")
                                              @NotEmpty(message = "move can not be empty") String move) throws FileOperationException {
        String computerAnswer = fizzBuzzService.play(move);
        return new ResponseEntity<>(new TurnResultDto(computerAnswer), HttpStatus.OK);
    }

    @Operation(summary = "returns correct value for given number")
    @Parameter(name = "answer", description = "number that you want to learn correct answer")
    @GetMapping("/ask/{number}")
    public ResponseEntity<TurnResultDto> correctAnswer(@PathVariable @Positive(message = "you can ask only positive numbers") int number) {
        return new ResponseEntity<>(new TurnResultDto(FizzBuzzGuru.getAnswer(number)), HttpStatus.OK);
    }
}
