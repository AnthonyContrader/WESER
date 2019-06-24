import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tutor-menu',
  templateUrl: './tutor-menu.component.html',
  styleUrls: ['./tutor-menu.component.css']
})
export class TutorMenuComponent implements OnInit {
  
  isAccountCollapsed = false;
  isEmergencyCollapsed = false;
  isPaymentCollapsed = false;
  isCureCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
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

  curescollapse() {
    if (this.isCureCollapsed === false) {
      this.isCureCollapsed = true;
    } else { this.isCureCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
