import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PatologyDTO } from 'src/dto/patologydto';
import { HttpClient } from '@angular/common/http';
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

}