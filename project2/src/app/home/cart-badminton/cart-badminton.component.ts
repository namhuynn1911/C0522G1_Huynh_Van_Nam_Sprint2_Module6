import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {IBadmintonDto} from '../../dto/i-badminton-dto';
import {CartDto} from '../../dto/cart-dto';
import {BadmintonService} from '../../service/badminton.service';
import {Title} from '@angular/platform-browser';
import {Router} from '@angular/router';
import {SumCart} from '../../dto/sum-cart';

@Component({
  selector: 'app-cart-badminton',
  templateUrl: './cart-badminton.component.html',
  styleUrls: ['./cart-badminton.component.css']
})
export class CartBadmintonComponent implements OnInit {

  cartList$: Observable<CartDto[]> | undefined;
  action: boolean;
  sumCart: SumCart;

  constructor(private badmintonService: BadmintonService,
              private title: Title,
              private router: Router) {
    this.title.setTitle('Trang chủ');
  }

  ngOnInit(): void {
    this.paginate();
    this.sum();
  }

  paginate() {
    this.badmintonService.findAllCart().subscribe(data => {
      if (data != null) {
        this.action = true;
        this.cartList$ = new BehaviorSubject<IBadmintonDto[]>(data);
      } else {
        this.action = false;
      }
    });
  }

  sum() {
    this.badmintonService.sumBill().subscribe(data => {
      this.sumCart = data;
    });
  }

  updateQAmount(cart: CartDto) {
    this.badmintonService.updateAmount(cart).subscribe(value => {
      this.ngOnInit();
    });
  }
  removeProduct(product: CartDto) {
    this.badmintonService.removeProduct(product.id).subscribe(value => {
      this.ngOnInit();
      // this.messageService.add({severity: 'error', summary: 'error', detail: 'Xóa san phẩm thành công'});
    });

  }
}
