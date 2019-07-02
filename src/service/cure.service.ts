import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { CureDTO } from 'src/dto/curedto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate i metodi ereditati dall'Abstract(in mirror con il backend).
 * 
 * @author PattyGè
 * 
 * @see AbstractService
 */
@Injectable({
    providedIn: 'root'
})
export class CureService extends AbstractService<CureDTO>{
   
    constructor(http: HttpClient) {
        super(http);
        this.nome = 'micro1';
        this.type ='cures';
       this.port = '8080';
    }

}