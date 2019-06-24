import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { EmergencyDTO } from 'src/dto/emergencydto';
import { PaymentDTO } from 'src/dto/paymentdto';
import { CureDTO } from 'src/dto/curedto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-tutor-dashboard',
  templateUrl: './tutor-dashboard.component.html',
  styleUrls: ['./tutor-dashboard.component.css']
})
export class TutorDashboardComponent implements OnInit {

  user: UserDTO;
  emergency: EmergencyDTO;
  payment: PaymentDTO;
  cure: CureDTO;

  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.emergency = JSON.parse(localStorage.getItem('currentEmergency'));
    this.payment = JSON.parse(localStorage.getItem('currentPayment'));
    this.cure = JSON.parse(localStorage.getItem('currentCure'));
  
  }

}

