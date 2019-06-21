import { Component, OnInit } from '@angular/core';
import { PatologyService } from 'src/service/patology.service';
import { PatologyDTO } from 'src/dto/patologydto';
@Component({
  selector: 'app-patologys',
  templateUrl: './patologys.component.html',
  styleUrls: ['./patologys.component.css']
})
export class PatologysComponent implements OnInit {

  patologys: PatologyDTO[];
  patologytoinsert: PatologyDTO = new PatologyDTO();

  constructor(private service: PatologyService) { }

  ngOnInit() {
    this.getPatologys();
  }

  getPatologys() {
    this.service.getAll().subscribe(patologys => this.patologys = patologys);
  }

  delete(patology: PatologyDTO) {
    this.service.delete(patology.id).subscribe(() => this.getPatologys());
  }

  update(patology: PatologyDTO) {
    this.service.update(patology).subscribe(() => this.getPatologys());
  }

  insert(patology: PatologyDTO) {
    this.service.insert(patology).subscribe(() => this.getPatologys());
  }

  clear(){
    this.patologytoinsert = new PatologyDTO();
  }
}
