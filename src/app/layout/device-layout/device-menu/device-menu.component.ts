import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-device-menu',
  templateUrl: './device-menu.component.html',
  styleUrls: ['./device-menu.component.css']
})
export class DeviceMenuComponent implements OnInit {

  isUserCollapsed = false;
  isAccountCollapsed = false;
  isDeviceCollapsed = false;
  isReadingCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  devicescollapse() {
    if (this.isDeviceCollapsed === false) {
      this.isDeviceCollapsed = true;
    } else { this.isDeviceCollapsed = false; }
  }

  readingscollapse() {
    if (this.isReadingCollapsed === false) {
      this.isReadingCollapsed = true;
    } else { this.isReadingCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
