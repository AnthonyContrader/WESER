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
    constructor(http: HttpClient) {
        super(http);
        this.nome = 'micro1';
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

    getAll(): Observable<EmergencyDTO[]> {
        return this.http.get<EmergencyDTO[]>('http://localhost:' + this.port + '/' + this.nome + '/' + this.type , {
         
        headers: {
            Authorization : this.auth()
            

          }
          
        });
        console.log(this.getAll)
      }
}