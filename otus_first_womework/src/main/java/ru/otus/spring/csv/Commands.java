package ru.otus.spring.CSV;

import java.io.IOException;

public interface Commands {

    void printQuestions() throws IOException;

    void askAnswers() throws IOException;

    int getWrightAnswersNumber();

    int getUserMark();
}
