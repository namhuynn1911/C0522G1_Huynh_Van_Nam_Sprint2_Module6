import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { BodyComponent } from './body/body.component';
import { ListBadmintonComponent } from './list-badminton/list-badminton.component';


@NgModule({
    declarations: [NavbarComponent, FooterComponent, BodyComponent, ListBadmintonComponent],
  exports: [
    NavbarComponent,
    FooterComponent,
    BodyComponent
  ],
    imports: [
        CommonModule,
        HomeRoutingModule
    ]
})
export class HomeModule { }
