import { Component, OnInit } from '@angular/core';
import { EmergencyService } from 'src/service/emergency.service';
import { EmergencyDTO } from 'src/dto/emergencydto';

@Component({
  selector: 'app-emergencys',
  templateUrl: './emergencys.component.html',
  styleUrls: ['./emergencys.component.css']
})
export class EmergencysComponent implements OnInit {

  emergencys: EmergencyDTO[];
  emergencytoinsert: EmergencyDTO = new EmergencyDTO();

  constructor(private service: EmergencyService) { }

  ngOnInit() {
    this.getEmergencys();
  }

  getEmergencys() {
    this.service.getAll().subscribe(emergencys => this.emergencys);
  }

  delete(emergency: EmergencyDTO) {
    this.service.delete(emergency.id).subscribe(() => this.getEmergencys());
  }

  update(emergency: EmergencyDTO) {
    this.service.update(emergency).subscribe(() => this.getEmergencys());
  }

  insert(emergency: EmergencyDTO) {
    this.service.insert(emergency).subscribe(() => this.getEmergencys());
  }

  clear(){
    this.emergencytoinsert = new EmergencyDTO();
  }



}

