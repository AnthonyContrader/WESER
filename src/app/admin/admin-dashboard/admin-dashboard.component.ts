import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { CureDTO } from 'src/dto/curedto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  user: UserDTO;
  cure: CureDTO;

  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.cure = JSON.parse(localStorage.getItem('currentCure'));
  }

}
