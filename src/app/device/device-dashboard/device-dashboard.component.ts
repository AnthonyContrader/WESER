import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { ReadingDTO } from 'src/dto/readingdto';
import { DeviceDTO } from 'src/dto/devicedto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-device-dashboard',
  templateUrl: './device-dashboard.component.html',
  styleUrls: ['./device-dashboard.component.css']
})
export class DeviceDashboardComponent implements OnInit {

  user: UserDTO;
  reading: ReadingDTO;
  device: DeviceDTO;

  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.reading = JSON.parse(localStorage.getItem('currentReading'));
    this.device = JSON.parse(localStorage.getItem('currentDevice'));
  }

}
