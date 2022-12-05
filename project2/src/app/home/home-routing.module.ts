import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BodyComponent} from './body/body.component';
import {DetailBadmintonComponent} from './detail-badminton/detail-badminton.component';
import {CartBadmintonComponent} from './cart-badminton/cart-badminton.component';


const routes: Routes = [
  {
    path: '', component: BodyComponent
  },
  {path: 'detail', component: DetailBadmintonComponent
  },
  {path: 'cart', component: CartBadmintonComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
