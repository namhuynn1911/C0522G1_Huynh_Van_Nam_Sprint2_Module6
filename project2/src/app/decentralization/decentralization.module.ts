import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DecentralizationRoutingModule } from './decentralization-routing.module';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    DecentralizationRoutingModule
  ]
})
export class DecentralizationModule { }
