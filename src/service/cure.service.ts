import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { AbstractService } from './abstractservice';
import { CureDTO } from 'src/dto/curedto';
import { HttpClient } from '@angular/common/http';
import { Observable, of, BehaviorSubject} from 'rxjs';
import { Cure } from 'src/models/Cure';
import { tap, catchError } from 'rxjs/operators';

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
        this.getAll();
    }
    
    
    private handleError<T>(operation = 'operation', result?: T) {

        return (error: any): Observable<T> => {

            console.error(error);

            console.log('${operation} failed: ${error.message}');

            return of(result as T);

        };

    }



    cureList(): Observable<Array<Cure>> {

        const cure: Cure = JSON.parse(sessionStorage.getItem('cure'));

        return this.http.get<any>('http://localhost:8080/Cure/cureManagement?id=' + cure.id)

            .pipe(tap((response) => console.log('Cure'), catchError(this.handleError('error', {})))

            );

    }



    
    insertCure(cure: Cure): void {

        this.http.post('http://localhost:8080/Cure/insert', cure).subscribe(() => console.log('Cure inserted'));

    }





    readCure(id: number): Observable<Cure> {

        return this.http.get<any>('http://localhost:8080/Cure/read?id=' + id)

            .pipe(tap((response) => console.log('Cure'), catchError(this.handleError('error', {})))

            );

    }



    deleteCure(id: number) {

        this.http.delete('http://localhost:8080/Cure/delete?id=' + id).subscribe(() => console.log('Cure deleted'));

    }



    updateCure(cure: Cure) {

        this.http.put('http://localhost:8080/Cure/update', cure).subscribe(() => console.log('Cure update'));

    }

}