import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PaymentDTO } from 'src/dto/paymentdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


 @Injectable({
     providedIn: 'root'
 })

 export class PaymentService extends AbstractService<PaymentDTO>{
   
    
    constructor(http: HttpClient) {
        super(http);
        this.nome = 'micro1';
        this.type ='payments';
       this.port = '8080';
    }
 }
