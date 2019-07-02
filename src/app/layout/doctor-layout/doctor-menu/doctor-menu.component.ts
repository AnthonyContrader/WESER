import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doctor-menu',
  templateUrl: './doctor-menu.component.html',
  styleUrls: ['./doctor-menu.component.css']
})
export class DoctorMenuComponent implements OnInit {

  isAccountCollapsed = false;
  isCureCollapsed = false;
  isDeviceCollapsed = false;
  isPatologyCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  curescollapse() {
    if (this.isCureCollapsed === false) {
      this.isCureCollapsed = true;
    } else { this.isCureCollapsed = false; }
  }

  devicescollapse() {
    if (this.isDeviceCollapsed === false) {
      this.isDeviceCollapsed = true;
    } else { this.isDeviceCollapsed = false; }
  }

  patologyscollapse() {
    if (this.isPatologyCollapsed === false) {
      this.isPatologyCollapsed = true;
    } else { this.isPatologyCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
