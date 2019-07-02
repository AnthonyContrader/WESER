import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DoctorLayoutComponent } from '../layout/doctor-layout/doctor-layout.component';
import { DoctorDashboardComponent } from './doctor-dashboard/doctor-dashboard.component';
import { UsersComponent } from './users/users.component';
import { CuresComponent } from './cures/cures.component';
import { DeviceDsComponent } from './deviceDs/deviceDs.component';
import { PatologysComponent } from './patologys/patologys.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see DoctorLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'doctor-dashboard', component: DoctorLayoutComponent, children:[
    { path: '', component: DoctorDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'cures', component: CuresComponent},
    { path: 'deviceDs', component: DeviceDsComponent},
    { path: 'patologys', component: PatologysComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DoctorRoutingModule { }