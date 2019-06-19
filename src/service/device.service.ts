import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { DeviceDTO } from 'src/dto/devicedto';
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
export class DeviceService extends AbstractService<DeviceDTO>{
   
    constructor(http: HttpClient) {
        super(http);
        this.type = 'device';
    }

}