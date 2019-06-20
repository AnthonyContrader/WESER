import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { CuresComponent } from './cures/cures.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { DevicesComponent } from './devices/devices.component';
import { EmergencysComponent } from './emergencys/emergencys.component';
import { PaymentsComponent } from './payments/payments.component';
import { ReadingsComponent } from './readings/readings.component';
import { PatologysComponent } from './patologys/patologys.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent, CuresComponent, WorkInProgressComponent, DevicesComponent, EmergencysComponent, PaymentsComponent, ReadingsComponent, PatologysComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
