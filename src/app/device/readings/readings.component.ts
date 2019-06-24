import { Component, OnInit } from '@angular/core';
import { ReadingDTO } from 'src/dto/readingdto';
import { ReadingService } from 'src/service/reading.service';

@Component({
  selector: 'app-readings',
  templateUrl: './readings.component.html',
  styleUrls: ['./readings.component.css']
})
export class ReadingsComponent implements OnInit {

  readings: ReadingDTO[];
  readingtoinsert: ReadingDTO = new ReadingDTO();

  constructor(private service: ReadingService) { }

  ngOnInit() {
    this.getReadings();
  }

  getReadings(){
    this.service.getAll().subscribe(readings => this.readings = readings );
  }

  delete(reading: ReadingDTO) {
    this.service.delete(reading.id).subscribe(() => this.getReadings());
  }

  update(reading: ReadingDTO){
    this.service.update(reading).subscribe(() => this.getReadings());
  }

  insert(reading: ReadingDTO) {
    this.service.insert(reading).subscribe(() => this.getReadings());
  }
  clear(){
    this.readingtoinsert = new ReadingDTO();
  }
}
