import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PaymentDTO } from 'src/dto/paymentdto';
import { UserDTO } from 'src/dto/userdto';
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

    auth() {
        const user = JSON.parse(localStorage.getItem('currentUser')) as UserDTO;
    
        console.log(user.authorities + 'user');
        if (user) {
          return 'Bearer ' + user.authorities;
        } else {
          return '';
        }
      }

      userLogged(username: string) {
        // console.log('qua: ', this.auth());
         console.log(this.auth());
         return this.http.get('http://localhost:8080/api/users/' + username, {
           headers: {
             Authorization: this.auth()
           }
         });
        }
 }
