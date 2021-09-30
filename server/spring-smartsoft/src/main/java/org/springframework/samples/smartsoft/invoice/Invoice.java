/* SMARTSOFT 2021
 */
package org.springframework.samples.smartsoft.invoice;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.smartsoft.model.BaseEntity;

/**
 * Simple JavaBean domain object representing an invoice.
 *
 * 
 * @author Luis Urbina
 */
@Entity
@Table(name = "invoice")
public class Invoice extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -712598966594557376L;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @NotEmpty
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "client_id")
    private Integer clientId;

    /**
     * Creates a new instance of Visit for the current date
     */
    public Invoice() {
	this.fecha = LocalDate.now();
    }

    public LocalDate getDate() {
	return this.fecha;
    }

    public void setDate(LocalDate date) {
	this.fecha = date;
    }

    public String getDescription() {
	return this.descripcion;
    }

    public void setDescription(String description) {
	this.descripcion = description;
    }

    public Integer getClientId() {
	return this.clientId;
    }

    public void setClientId(Integer clientId) {
	this.clientId = clientId;
    }

}
