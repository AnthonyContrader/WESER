import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ReadingDTO } from 'src/dto/readingdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


 @Injectable({
     providedIn: 'root'
 })

 export class ReadingService extends AbstractService<ReadingDTO>{
   
    
    constructor(http: HttpClient) {
        super(http);
        this.nome = 'micro1';
        this.type ='readings';
       this.port = '8080';

    }
 }
