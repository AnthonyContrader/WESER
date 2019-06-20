import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TutorRoutingModule } from './tutor-routing.module';
import { TutorDashboardComponent } from './tutor-dashboard/tutor-dashboard.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { EmergencysComponent } from './emergencys/emergencys.component';
import { PaymentsComponent } from './payments/payments.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [TutorDashboardComponent, WorkInProgressComponent, EmergencysComponent, PaymentsComponent ],
  imports: [
    CommonModule,
    TutorRoutingModule,
    FormsModule
  ]
})
export class TutorModule { }
