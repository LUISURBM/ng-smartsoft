/*
 * SMARTSOFT 2021
 */
package org.springframework.samples.smartsoft.invoice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.samples.smartsoft.model.BaseEntity;

/**
 * Simple JavaBean domain object representing an person.
 *
 * 
 */

@Entity
@Table(name = "invoice")
public class Person extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -3298257038048470507L;

    @Column(name = "first_name")
    @NotEmpty
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty
    private String lastName;

    public String getFirstName() {
	return this.firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return this.lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

}
