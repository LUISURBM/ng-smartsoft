/*
 * SMARTSOFT 2021
 */
package org.springframework.samples.smartsoft.invoice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.smartsoft.model.NamedEntity;

/**
 * Simple business object representing a pet.
 *
 * 
 * @author Luis Urbina
 * 
 */
@Entity
@Table(name = "detalle")
public class Detalle extends NamedEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 8450175924470653653L;

    @Column(name = "cantidad")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private BigDecimal cantidad;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCantidad() {
        return this.cantidad;
    }

    public Invoice getInvoice() {
        return this.invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

}
