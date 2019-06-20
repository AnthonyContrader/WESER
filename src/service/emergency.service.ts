import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { EmergencyDTO } from 'src/dto/emergencydto';
import { HttpClient } from '@angular/common/http';
import {Observable, of, BehaviorSubject } from 'rxjs';
/**
 * @author Andrea Pirro
 */
@Injectable({
    providedIn: 'root'
})
export class EmergencyService extends AbstractService<EmergencyDTO>{
    constructor(http: HttpClient){
        super(http);
        this.type= 'emergency';
    }

}