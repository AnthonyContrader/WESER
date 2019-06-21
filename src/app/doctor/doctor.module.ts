import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DoctorRoutingModule } from './doctor-routing.module';
import { DoctorDashboardComponent } from './doctor-dashboard/doctor-dashboard.component';
import { UsersComponent } from './users/users.component';
import { CuresComponent } from './cures/cures.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { DevicesComponent } from './devices/devices.component';
import { PatologysComponent } from './patologys/patologys.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see DoctorRoutingModule
 */
@NgModule({
  declarations: [DoctorDashboardComponent, UsersComponent, CuresComponent, WorkInProgressComponent, DevicesComponent, PatologysComponent],
  imports: [
    CommonModule,
    DoctorRoutingModule,
    FormsModule
  ]
})
export class DoctorModule { }
