/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Francesco
 */
public class Dates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        printDate(today);

        System.out.println(today.format(DateTimeFormatter.ISO_DATE));

        LocalDate yesterday = today.minusDays(1);
        printDate(yesterday);

        LocalDate daquiA10Dias = today.plusDays(10);
        printDate(daquiA10Dias);

        Period period = today.until(daquiA10Dias);
        System.out.println(period.getDays());

        LocalDate dateOfBirth = LocalDate.of(2012, Month.MAY, 14);
        printDate(dateOfBirth);
        LocalDate firstBirthday = dateOfBirth.plusYears(1);
        printDate(firstBirthday);
    }

    private static void printDate(LocalDate today) {
        System.out.printf("%s-%s-%s\n",
                today.getYear(), today.getMonthValue(), today.getDayOfMonth()
        );
    }
}
