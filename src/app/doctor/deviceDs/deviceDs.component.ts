import { Component, OnInit } from '@angular/core';
import { DeviceService } from 'src/service/device.service';
import { DeviceDTO } from 'src/dto/devicedto';

@Component({
  selector: 'app-deviceDs',
  templateUrl: './deviceDs.component.html',
  styleUrls: ['./deviceDs.component.css']
})
export class DeviceDsComponent implements OnInit {

  devices: DeviceDTO[];

  constructor(private service: DeviceService) { }

  ngOnInit() {
    this.getDevices();
  }

  getDevices() {
    this.service.getAll().subscribe(devices => this.devices = devices);
  }

  delete(device: DeviceDTO) {
    this.service.delete(device.id).subscribe(() => this.getDevices());
  }

  update(device: DeviceDTO) {
    this.service.update(device).subscribe(() => this.getDevices());
  }

}