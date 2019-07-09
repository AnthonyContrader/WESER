import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { EmergencyDTO } from 'src/dto/emergencydto';
import { HttpClient } from '@angular/common/http';
import {Observable, of, BehaviorSubject } from 'rxjs';
import { UserDTO } from 'src/dto/userdto';
/**
 * @author Andrea Pirro
 */
@Injectable({
    providedIn: 'root'
})
export class EmergencyService extends AbstractService<EmergencyDTO>{
    constructor(protected http: HttpClient) {
        super(http);
        this.nome = 'micro2';
        this.type ='emergencies';
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