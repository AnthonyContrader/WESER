import { Component, OnInit } from '@angular/core';
import { CureService } from 'src/service/cure.service';
import { CureDTO } from 'src/dto/curedto';
import { PatologyDTO } from 'src/dto/patologydto';
import { ReadingDTO } from 'src/dto/readingdto';

@Component({
  selector: 'app-cureTs',
  templateUrl: './cureTs.component.html',
  styleUrls: ['./cureTs.component.css']
})
export class CureTsComponent implements OnInit {

  cures: CureDTO[];

  constructor(private service: CureService) { }

  ngOnInit() {
    this.getCures();

  }

  getCures() {
    this.service.getAll().subscribe(data => {
      console.log(data);
      this.cures = data;
    });
  }

}
