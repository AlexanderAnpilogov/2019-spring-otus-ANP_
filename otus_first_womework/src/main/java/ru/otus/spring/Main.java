package ru.otus.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.spring.app.TesterApp;
import ru.otus.spring.student.Stud;


import java.io.*;

@ComponentScan
public class Main {
    //позволяет использовать SpEL-bundl'ы
    @Bean
    PropertySourcesPlaceholderConfigurer propertyConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();}

    //настройка сообщения
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/bundle/");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TesterApp app = context.getBean(TesterApp.class);
        app.startApplication();
    }
}
