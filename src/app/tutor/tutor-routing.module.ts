import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TutorLayoutComponent } from '../layout/tutor-layout/tutor-layout.component';
import { TutorDashboardComponent } from './tutor-dashboard/tutor-dashboard.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { UsersComponent } from './users/users.component';
import { EmergencysComponent } from './emergencys/emergencys.component';
import { PaymentsComponent } from './payments/payments.component';
import { CureTsComponent } from './cureTs/cureTs.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see TutorLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'tutor-dashboard', component: TutorLayoutComponent, children:[
    { path: '', component: TutorDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'cureTs', component: CureTsComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent},
    { path: 'emergencys', component: EmergencysComponent},
    { path: 'payments', component: PaymentsComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TutorRoutingModule { }