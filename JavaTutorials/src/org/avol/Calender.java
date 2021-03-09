package org.avol;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

/**
 * Created by lovababu on 21/08/18.
 */
public class Calender {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDate dateTime = LocalDate.parse("2016-03-04", formatter);
        System.out.println(dateTime);

        try {
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(GregorianCalendar.from(dateTime.atStartOfDay(ZoneId.systemDefault())));
            System.out.println(xmlGregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }
}
