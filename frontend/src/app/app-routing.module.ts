import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BootComponent } from './core/boot/boot.component';
import { LoginComponent } from './core/login/login.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'boot', component: BootComponent },
  { path: '', redirectTo: '/boot', pathMatch: 'full' },
  { path: '**', redirectTo: '/boot' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
