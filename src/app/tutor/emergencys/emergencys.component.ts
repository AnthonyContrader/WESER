import { Component, OnInit } from '@angular/core';
import { EmergencyService } from 'src/service/emergency.service';
import { EmergencyDTO } from 'src/dto/emergencydto';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-emergencys',
  templateUrl: './emergencys.component.html',
  styleUrls: ['./emergencys.component.css']
})
export class EmergencysComponent implements OnInit {

  emergencys: EmergencyDTO[];
  emergencytoinsert: EmergencyDTO = new EmergencyDTO();
  emergenciesx: any;

  constructor(private service: EmergencyService) { }

  ngOnInit() {
    this.getEmergencies();
  }
  
  getEmergencies() {
    this.service.getAll().subscribe( (data:any)  => 
      {
        console.log(data);
      this.emergencys = data;
      
      this.emergenciesx = data[0];
      console.log("this.emergenciesx");
      });
    
  }

  delete(emergency: EmergencyDTO) {
    this.service.delete(emergency.id).subscribe(() => this.getEmergencies());
  }

  update(emergency: EmergencyDTO) {
    this.service.update(emergency).subscribe(() => this.getEmergencies());
  }

  insert(emergency: EmergencyDTO) {
    this.service.insert(emergency).subscribe(() => this.getEmergencies());
  }

  clear(){
    this.emergencytoinsert = new EmergencyDTO();
  }

}