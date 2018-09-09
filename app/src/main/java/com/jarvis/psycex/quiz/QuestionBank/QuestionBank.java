package com.jarvis.psycex.quiz.QuestionBank;

// This file contains questions from QuestionBank

public class QuestionBank {

    // array of questions
    private String textQuestions [] = {
            "When did Google acquired Android?",
            "What is the name of build toolkit for Android Studio?",
            "What widget can replace any use of radio buttons?",
            "Android application implements principle of _____."
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"2003", "2004", "2005", "2006"},
            {"JVM", "Gradle", "Dalvik", "HAXM"},
            {"Toggle Button", "Spinner", "Switch Button", "ImageButton"},
            {"least privileges", "most privileges", "unique privileges", "none of the above"}
    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswersText[] = {"2005", "Gradle", "Spinner", "least privileges"};
    private String mCorrectAnswersChoice[] = {"C", "B", "B", "A"};

    // method returns number of questions
    public int getNumberOfQuestions(){
        return textQuestions.length;
    }

    // method returns question from array textQuestions[] based on array index
    public String getQuestion(int questionNumber_1indexed) {
        String question = Integer.toString(questionNumber_1indexed) +". " + textQuestions[questionNumber_1indexed-1]; // Make in format "1. What is your name?"
        return question;
    }

    // method return a single multiple choice item for question based on array index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4 as an argument
    public String getChoice(int questionNumber_1indexed, int num) {
        String[] intToAlpha = {"A", "B", "C", "D"};
        String choiceString = intToAlpha[num - 1] + ". " + multipleChoice[questionNumber_1indexed - 1][num-1];
        return choiceString;
    }

    //  method returns correct answer choice for the question based on array index
    public String getCorrectAnswersChoice(int questionNumber_1indexed) {
        String answerChoice = mCorrectAnswersChoice[questionNumber_1indexed -1 ];
        return answerChoice;
    }

    //  method returns correct answer text for the question based on array index
    public String getCorrectAnswersText(int questionNumber_1indexed) {
        String answerText = mCorrectAnswersText[questionNumber_1indexed -1 ];
        return answerText;
    }


}