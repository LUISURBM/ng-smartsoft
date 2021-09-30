import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { BehaviorSubject, forkJoin } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ng-smartsoft';
  state$ = new BehaviorSubject<SmartsoftState>({});
  invoices = false;
  products = false;
  persons = false;
  precio = new FormControl('');
  stock = new FormControl('');
  name = new FormControl('');
  firstName = new FormControl('');
  lastName = new FormControl('');
  fecha = new FormControl('');
  clientId = new FormControl('');
  descripcion = new FormControl('');
  

  constructor(private http: HttpClient) {

    forkJoin({
      persons: this.http.get<any>('localhost:8080/persons'),
      invoices: this.http.get<any>('localhost:8080/invoices'),
      products: this.http.get<any>('localhost:8080/products'),
    }).subscribe({
      next: value => this.state$.next(value)
    });
  }
  view(i: any) {
    if (i === 1) {
      this.persons = true;
      this.invoices = false;
      this.products = false;
    } if (i === 2) {
      this.persons = false;
      this.invoices = true;
      this.products = false;
    } if (i === 3) {
      this.persons = false;
      this.invoices = false;
      this.products = true;
    }
  }
  savePerson(p: any) {
    this.http.post<any>('localhost:8080/product', p, httpOptions).subscribe({
      next: value => this.state$.next({ ...this.state$.value, msg: value })
    })
  }
  saveProduct(p: any) {
    this.http.post<any>('localhost:8080/product', p, httpOptions).subscribe({
      next: value => this.state$.next({ ...this.state$.value, msg: value })
    })
  }
  saveInvoice(p: any) {
    this.http.post<any>('localhost:8080/invoice', p, httpOptions).subscribe({
      next: value => this.state$.next({ ...this.state$.value, msg: value })
    })
  }
}
export const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: 'token-sf'
  })
};
export interface SmartsoftState {
  persons?: any[];
  invoices?: any[];
  products?: any[];
  msg?: string;
}