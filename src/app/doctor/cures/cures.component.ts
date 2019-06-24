import { Component, OnInit } from '@angular/core';
import { CureService } from 'src/service/cure.service';
import { CureDTO } from 'src/dto/curedto';
import { PatologyDTO } from 'src/dto/patologydto';
import { ReadingDTO } from 'src/dto/readingdto';

@Component({
  selector: 'app-cures',
  templateUrl: './cures.component.html',
  styleUrls: ['./cures.component.css']
})
export class CuresComponent implements OnInit {

  cures: CureDTO[];
 curetoinsert: CureDTO = new CureDTO();

  constructor(private service: CureService) { }

  ngOnInit() {
    this.getCures();
    this.curetoinsert = new CureDTO();
    this.curetoinsert.patologyDTO = new PatologyDTO();
    this.curetoinsert.readingDTO = new ReadingDTO();
  }

  getCures() {
    this.service.getAll().subscribe(data => {
      console.log(data);
      this.cures = data;
    });
  }

  delete(cure: CureDTO) {
    this.service.delete(cure.id).subscribe(() => this.getCures());
  }

  update(cure: CureDTO) {
    this.service.update(cure).subscribe(() => this.getCures());
  }

  insert(cure: CureDTO) {
    console.log(this.curetoinsert);
    this.service.insert(this.curetoinsert).subscribe(() => this.getCures());
    console.log();
  }

  clear(){
    this.curetoinsert = new CureDTO();
  }
}
