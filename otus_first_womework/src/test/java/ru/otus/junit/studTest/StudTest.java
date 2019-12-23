package ru.otus.junit.StudTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.App.TesterApp;
import ru.otus.spring.CSV.CSV;
import ru.otus.spring.CSV.Commands;
import ru.otus.spring.Student.Stud;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudTest {
    @DisplayName("Правиьно инициализирует студента при создании")
    @Test
    void constructor() {
        Stud stud = new Stud("Name", "Surname");

        assertEquals("Name", stud.getNama());
        assertEquals("Surname", stud.getSurnama());
    }

    @DisplayName("методы интерфейса правильно переопределены и работают")
    @Test
    void WrightWorkingOfGetterAndSetter() {
        Stud stud = new Stud();
        stud.setNama("f");
        stud.setSurNama("g");

        assertEquals("f", stud.getNama());
        assertEquals("g", stud.getSurnama());
    }
}
