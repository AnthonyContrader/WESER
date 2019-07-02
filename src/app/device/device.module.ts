import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DeviceRoutingModule } from './device-routing.module';
import { DeviceDashboardComponent } from './device-dashboard/device-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { DevicesComponent } from './devices/devices.component';
import { ReadingsComponent } from './readings/readings.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see DeviceRoutingModule
 */
@NgModule({
  declarations: [DeviceDashboardComponent, UsersComponent, WorkInProgressComponent, DevicesComponent, ReadingsComponent],
  imports: [
    CommonModule,
    DeviceRoutingModule,
    FormsModule
  ]
})
export class DeviceModule { }
