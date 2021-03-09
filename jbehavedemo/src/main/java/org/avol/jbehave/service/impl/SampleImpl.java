package org.avol.jbehave.service.impl;

import lombok.AllArgsConstructor;
import org.avol.jbehave.dao.SampleDao;
import org.avol.jbehave.service.Sample;

/**
 * Created by lovababu on 09/09/18.
 */
@AllArgsConstructor
public class SampleImpl implements Sample {

    private SampleDao sampleDao;

    public String greet(String name) {
        sampleDao.save(name);
        return String.format("Hello Mr/Mrs. %s, welcome to serenity world.", name);
    }
}
