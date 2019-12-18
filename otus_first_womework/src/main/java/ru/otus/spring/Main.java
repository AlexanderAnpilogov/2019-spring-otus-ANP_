package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.App.TesterApp;
import ru.otus.spring.CSV.CSV;


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TesterApp app = context.getBean(TesterApp.class);
        app.identifyStudent();
        app.showQuestions();
        app.testEnding();
    }
}
