/*
 * SMARTSOFT 2021
 */
package org.springframework.samples.smartsoft.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.samples.smartsoft.invoice.Invoice;
import org.springframework.samples.smartsoft.invoice.InvoiceRepository;
import org.springframework.samples.smartsoft.invoice.Person;
import org.springframework.samples.smartsoft.invoice.PersonRepository;
import org.springframework.samples.smartsoft.invoice.ProductRepository;
import org.springframework.samples.smartsoft.invoice.Producto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luis Urbina
 * 
 * 
 * 
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
class InvoiceController {

    private final InvoiceRepository invoice;
    private final ProductRepository product;
    private final PersonRepository person;

    public InvoiceController(InvoiceRepository invoiceSrv, PersonRepository personRepo, ProductRepository productRepo) {
	this.invoice = invoiceSrv;
	person = personRepo;
	product = productRepo;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/invoice/new")
    public @ResponseBody String processCreationForm(@Valid Invoice invoice, BindingResult result) {
	if (result.hasErrors()) {
	    return "Con errores";
	} else {
	    this.invoice.save(invoice);
	    return invoice.getId().toString();
	}
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/invoice/{invoiceId}")
    public @ResponseBody String initUpdateInvoiceForm(@PathVariable("invoiceId") int invoiceId) {
	return this.invoice.findById(invoiceId).toString();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/invoices")
    public @ResponseBody List<Invoice> getTableInvoiceData() {
	return this.invoice.findAll();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/products")
    public List<Producto> getTableProductData() {
	return this.product.findAll();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/persons")
    public @ResponseBody List<Person> getTablePersonData() {
	return this.person.findAll();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/person/new")
    public @ResponseBody String processCreationForm(@Valid Person person, BindingResult result) {
	if (result.hasErrors()) {
	    return "Con errores";
	} else {
	    this.person.save(person);
	    return "redirect:/person/" + person.getId();
	}
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/person/{personId}")
    public @ResponseBody String initUpdatePersonForm(@PathVariable("personId") int personId) {
	return this.person.findById(personId).toString();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/product/new")
    public @ResponseBody String processCreationForm(@Valid Producto product, BindingResult result) {
	if (result.hasErrors()) {
	    return "Con errores";
	} else {
	    this.product.save(product);
	    return "redirect:/product/" + product.getId();
	}
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/product/{productId}")
    public @ResponseBody String initUpdateProductForm(@PathVariable("productId") int productId) {
	return this.product.findById(productId).toString();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/invoice/{invoiceId}/edit")
    public @ResponseBody String processUpdateInvoiceForm(@Valid Invoice invoice, BindingResult result,
	    @PathVariable("invoiceId") int invoiceId) {
	if (result.hasErrors()) {
	    return "Con errores";
	} else {
	    invoice.setId(invoiceId);
	    this.invoice.save(invoice);
	    return "Ok";
	}
    }

}
