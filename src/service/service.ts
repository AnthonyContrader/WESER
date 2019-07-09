import { Observable } from 'rxjs';

/**
 * Interfaccia che firma i metodi per le CRUD. Per dettagli sul pattern Observer far riferimento alla guida
 * o cercare online (raccomando la seconda, siate autonomi!).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
export interface Service<DTO> {

    read(id: number): Observable<DTO> ;

    delete(id: number): Observable<DTO>;

    deleteU(login: string): Observable<DTO>;

    update(dto: DTO): Observable<DTO> ;

    insert(dto: DTO): Observable<DTO> ;

    getAll(): Observable<DTO[]>;

}
