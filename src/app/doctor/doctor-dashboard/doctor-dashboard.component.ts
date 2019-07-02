import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { CureDTO } from 'src/dto/curedto';
import { DeviceDTO } from 'src/dto/devicedto';
import { PatologyDTO } from 'src/dto/patologydto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-doctor-dashboard',
  templateUrl: './doctor-dashboard.component.html',
  styleUrls: ['./doctor-dashboard.component.css']
})
export class DoctorDashboardComponent implements OnInit {

  user: UserDTO;
  cure: CureDTO;
  device: DeviceDTO;
  patology: PatologyDTO;

  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.cure = JSON.parse(localStorage.getItem('currentCure'));
    this.device = JSON.parse(localStorage.getItem('currentDevice'));
    this.patology = JSON.parse(localStorage.getItem('currentPatology'));
  }

}
