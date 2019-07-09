import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PatologyDTO } from 'src/dto/patologydto';
import { HttpClient } from '@angular/common/http';
import { UserDTO } from 'src/dto/userdto';
import {Observable, of, BehaviorSubject } from 'rxjs';
/**
 * @author Andrea Pirro
 */
@Injectable({
    providedIn: 'root'
})
export class PatologyService extends AbstractService<PatologyDTO>{
    constructor(http: HttpClient) {
        super(http);
        this.nome = 'micro1';
        this.type ='patologies';
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