import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { BodyComponent } from './body/body.component';
import { ListBadmintonComponent } from './list-badminton/list-badminton.component';
import { DetailBadmintonComponent } from './detail-badminton/detail-badminton.component';
import { CartBadmintonComponent } from './cart-badminton/cart-badminton.component';


@NgModule({
    declarations: [NavbarComponent, FooterComponent, BodyComponent, ListBadmintonComponent, DetailBadmintonComponent, CartBadmintonComponent],
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
