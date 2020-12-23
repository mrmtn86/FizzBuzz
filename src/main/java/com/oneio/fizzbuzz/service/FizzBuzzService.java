package com.oneio.fizzbuzz.service;

import com.oneio.fizzbuzz.exception.FileOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.oneio.fizzbuzz.util.FizzBuzzGuru.getAnswer;
import static java.text.MessageFormat.format;


@Service
public class FizzBuzzService {

    public static final String COMPUTER_START_REQUEST = "youStart";
    public static final String USER_ANSWER_NOT_CORRECT = "user answer is not correct : {0} but correct answer was : {1}";
    public static final String COMPUTER_STARTING_TO_GAME = "computer starting to game";
    public static final String USER_STARTING_TO_GAME = "user starting to game";
    public static final String COMPUTER_ANSWERING = "Computer answering : ";
    public static final String WRONG_ANSWER_MESSAGE = "Ups correct answer was ''{0}''- GAME OVER";

    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzService.class);
    private final FizzBuzzNumberTracker numberTracker;

    public FizzBuzzService(FizzBuzzNumberTracker numberTracker) throws FileOperationException {
        this.numberTracker = numberTracker;
        this.numberTracker.reset();
    }

    public String play(String userRequest) throws FileOperationException {

        logger.debug("user requested :  " + userRequest);

        if (userRequest.equals(COMPUTER_START_REQUEST)) { // new game computer starts

            logger.debug(COMPUTER_STARTING_TO_GAME);
            return String.valueOf(numberTracker.start());  // reset to 1

        } else if (userRequest.equals("1")) { // new game user starts
            logger.debug(USER_STARTING_TO_GAME);
            numberTracker.start();//reset to 1 because player started to game
            return String.valueOf(numberTracker.next());  //return next for computer answer : 2
        }

        //check user's answer is correct
        String correctAnswer = getAnswer(numberTracker.next());
        if (!correctAnswer.equals(userRequest)) {
            logger.debug(format(USER_ANSWER_NOT_CORRECT, userRequest, correctAnswer));
            //stop game counter
            numberTracker.reset();
            //return correct answer to player
            return format(WRONG_ANSWER_MESSAGE, correctAnswer);
        }

        //user's answer is correct, computer's turn
        String answer = getAnswer(numberTracker.next());

        logger.debug(COMPUTER_ANSWERING + answer);

        return answer;
    }
}
