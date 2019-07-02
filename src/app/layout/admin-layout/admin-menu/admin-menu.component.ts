import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isCureCollapsed = false;
  isDeviceCollapsed = false;
  isEmergencyCollapsed = false;
  isPaymentCollapsed = false;
  isReadingCollapsed = false;
  isPatologyCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.removeItem("currentUser");
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
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

  emergencyscollapse() {
    if (this.isEmergencyCollapsed === false) {
      this.isEmergencyCollapsed = true;
    } else { this.isEmergencyCollapsed = false; }
  }

  paymentscollapse() {
    if (this.isPaymentCollapsed === false) {
      this.isPaymentCollapsed = true;
    } else { this.isPaymentCollapsed = false; }
  }

  readingscollapse() {
    if (this.isReadingCollapsed === false) {
      this.isReadingCollapsed = true;
    } else { this.isReadingCollapsed = false; }
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
