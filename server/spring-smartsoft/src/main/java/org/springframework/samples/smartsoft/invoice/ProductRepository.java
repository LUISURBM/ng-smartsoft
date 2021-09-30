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
 * @author Luis Urbina
 * 
 * 
 */
public interface ProductRepository extends Repository<Producto, Integer> {

    /**
     * Save a <code>Producto</code> to the data store, either inserting or updating it.
     *
     * @param producto the <code>Producto</code> to save
     * @see BaseEntity#isNew
     */
    void save(Producto producto) throws DataAccessException;

    List<Producto> findById(Integer id);

    List<Producto> findAll();

}

