import { Component, OnInit } from '@angular/core';
import { CureService } from 'src/service/cure.service';
import { CureDTO } from 'src/dto/curedto';

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
    this.service.getAll().subscribe(cures => this.cures = cures);
  }

}
