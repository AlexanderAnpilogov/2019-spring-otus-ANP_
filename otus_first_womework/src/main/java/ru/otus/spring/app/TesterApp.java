package ru.otus.spring.App;

import ru.otus.spring.CSV.Commands;
import ru.otus.spring.Student.Person;
import ru.otus.spring.Student.Stud;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesterApp {
    private final Commands csv;
    private Person student;

    public TesterApp(Commands csv) {
        this.csv = csv;
    }

    public void showQuestions() throws IOException {
        csv.printQuestions();
    }

    protected void askAnswers() throws IOException {
        csv.askAnswers();
    }

    public void identifyStudent() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("введите имя и фамилию...");
        String nama = reader.readLine();
        String surNama = reader.readLine();
        student = new Stud();
        student.setNama(nama);
        student.setSurNama(surNama);
    }

    public void testEnding() {
        System.out.println("                                " + student.getNama() + " " + student.getSurnama());
        csv.getUserMark();
    }
}
