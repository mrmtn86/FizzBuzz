package com.oneio.fizzbuzz.model;

public class TurnResultDto {
    String answer;

    public TurnResultDto(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
