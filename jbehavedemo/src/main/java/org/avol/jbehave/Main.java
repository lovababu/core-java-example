package org.avol.jbehave;

import org.avol.jbehave.dao.impl.SampleDaoImpl;
import org.avol.jbehave.service.Sample;
import org.avol.jbehave.service.impl.SampleImpl;

/**
 * Created by lovababu on 09/09/18.
 */
public class Main {

    public static void main(String[] args) {
        Sample sample = new SampleImpl(new SampleDaoImpl());
        System.out.println(sample.greet("Srilekha"));;

    }
}
