package org.avol.jbehave.dao.impl;

import org.avol.jbehave.dao.SampleDao;

import java.util.Random;

/**
 * Created by lovababu on 09/09/18.
 */
public class SampleDaoImpl implements SampleDao {

    /**
     * Assume, this method is going store each user getting wished by system, and assign unique identifier.
     *
     * @param name
     * @return
     */
    public long save(String name) {
        return new Random(1000).nextInt();
    }
}
