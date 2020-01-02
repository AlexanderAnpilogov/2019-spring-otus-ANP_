package ru.otus.spring.csv;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Locale;


//позволяет использовать поля моего property-файла используя плейсхолдеры(@Value("${my.csv}") языка SpEL
//но чтобы использовать SpEL нужно в Main-классе создать Bean PropertySoursePlaceHolderConfigurer( см. Main-class)...
//@PropertySource("classpath:/info.property")
@Service
public class CSV implements Commands {

    public MessageSource messageSource;

   // @Value("${my.csv}")
   // private String path;

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String[] userAnswerMassive = new String[5];
    private String[] trueAnswers = {"1,3,4", "2", "3", "4", "3,2"};
    private int userWrightAnswers = 0;

    @Override
    public int getUserMark() {
        if (userWrightAnswers < 3) {
            System.out.println("Вы не прошли тестирование, ответив менее чем на 3 вопроса, правильных ответов - " +
                    +userWrightAnswers + "\n " + " |ПОДГОТОВЬТЕСЬ ПОЛУЧШЕ И ПОПРОБУЙТЕ ЕЩЁ РАЗ");
            return 2;
        } else if (userWrightAnswers == 3) {
            System.out.println("Вы успешно прошли тестирование с чем Вас и поздравляем! правильных ответов - " +
                    +userWrightAnswers);
            System.out.println("ВАША ОЦЕНКА - " + 3);
            return 3;
        } else if (userWrightAnswers == 4) {
            System.out.println("Вы успешно прошли тестирование с чем Вас и поздравляем! правильных ответов - " + userWrightAnswers);
            System.out.println("ВАША ОЦЕНКА - " + 4);
            return 4;
        } else {
            System.out.println("Вы успешно прошли тестирование с чем Вас и поздравляем! правильных ответов - " + userWrightAnswers);
            System.out.println("ВАША ОЦЕНКА - " + 5);
            System.out.println("Кросаучег =)");
            return 5;
        }
    }

    @Override
    public int getWrightAnswersNumber() {
        return userWrightAnswers;
    }

    @Override
    public void printQuestions() throws IOException {

        FileReader fr =new FileReader(messageSource.getMessage("my.csv",null, null));
        BufferedReader reader = new BufferedReader(fr);
        String a;
        while (!(a = reader.readLine()).isEmpty()) { System.out.println(a);}
        askAnswers();
    }

    @Override
    public void askAnswers() throws IOException {
        System.out.println();
        for (int i = 1; i < 6; i++) {
            System.out.println("Введите ответ на вопрос " + i);
            String answer = reader.readLine();
            userAnswerMassive[i - 1] = answer;
        }
        System.out.println("это ваши окончательные ответы? можн проверить? Y/N");
        if (reader.readLine().equalsIgnoreCase("Y")) {

            for (int i = 0; i < 5; i++) {
                if (userAnswerMassive[i].equals(trueAnswers[i])) {
                    userWrightAnswers++;
                }
            }
        } else {
            System.out.println("тогда сиди и думаай дальше");
        }
    }
}




