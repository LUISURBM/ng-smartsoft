/*
 * SMARTSOFT 2021
 */
package org.springframework.samples.smartsoft.invoice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.samples.smartsoft.model.BaseEntity;

/**
 * Simple JavaBean domain object representing an owner.
 *
 * 
 * @author Luis Urbina
 * 
 * 
 */
@Entity
@Table(name = "producto")
public class Producto extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = -8969438606307706664L;

    @Column(name = "precio")
    @NotEmpty
    private BigDecimal precio;

    @Column(name = "stock")
    @NotEmpty
    private BigDecimal stock;

    @Column(name = "first_name")
    @NotEmpty
    private String firstName;
    public String getFirstName() {
	return this.firstName;
    }


    public BigDecimal getPrecio() {
        return this.precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getStock() {
        return this.stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

}
