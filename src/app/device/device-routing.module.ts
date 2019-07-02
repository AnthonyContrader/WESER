import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DeviceLayoutComponent } from '../layout/device-layout/device-layout.component';
import { DeviceDashboardComponent } from './device-dashboard/device-dashboard.component';
import { UsersComponent } from './users/users.component';
import { DevicesComponent } from './devices/devices.component';
import { ReadingsComponent } from './readings/readings.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see DeviceLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'device-dashboard', component: DeviceLayoutComponent, children:[
    { path: '', component: DeviceDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'devices', component: DevicesComponent},
    { path: 'readings', component: ReadingsComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DeviceRoutingModule { }