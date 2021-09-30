/*
 * SMARTSOFT 2021
 */
package org.springframework.samples.smartsoft.invoice;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.samples.smartsoft.model.BaseEntity;

/**
 *
 * 
 * @author Luis Urbina
 * 
 * 
 */
public interface PersonRepository extends Repository<Person, Integer> {

    /**
     * Save a <code>Person</code> to the data store, either inserting or updating it.
     *
     * @param person the <code>Person</code> to save
     * @see BaseEntity#isNew
     */
    void save(Person person) throws DataAccessException;

    List<Person> findById(Integer id);

    List<Person> findAll();

}
