import { Component, OnInit } from '@angular/core';
import { DeviceService } from 'src/service/device.service';
import { DeviceDTO } from 'src/dto/devicedto';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.css']
})
export class DevicesComponent implements OnInit {

  devices: DeviceDTO[];
 devicetoinsert: DeviceDTO = new DeviceDTO();

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

  insert(device: DeviceDTO) {
    this.service.insert(device).subscribe(() => this.getDevices());
  }

  clear(){
    this.devicetoinsert = new DeviceDTO();
  }
}