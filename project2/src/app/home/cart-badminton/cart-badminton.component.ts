import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {IBadmintonDto} from '../../dto/i-badminton-dto';
import {CartDto} from '../../dto/cart-dto';
import {BadmintonService} from '../../service/badminton.service';
import {Title} from '@angular/platform-browser';
import {Router} from '@angular/router';
import {SumCart} from '../../dto/sum-cart';
import {render} from 'creditcardpayments/creditCardPayments';
import {TokenStorageService} from '../../service/token-storage.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cart-badminton',
  templateUrl: './cart-badminton.component.html',
  styleUrls: ['./cart-badminton.component.css']
})
export class CartBadmintonComponent implements OnInit {

  cartList$: Observable<CartDto[]> | undefined;
  action: boolean;
  sumCart: SumCart;
  username: string;
  nameDelete: string;

  constructor(private badmintonService: BadmintonService,
              private title: Title,
              private router: Router,
              private tokenStorageService: TokenStorageService) {
    this.title.setTitle('Trang chủ');
  }

  ngOnInit(): void {
    this.username = this.tokenStorageService.getUser().username;
    this.paginate();
    this.sum();
  }

  paginate() {
    this.badmintonService.findAllCart(this.username).subscribe(data => {
      if (data != null) {
        this.action = true;
        this.cartList$ = new BehaviorSubject<IBadmintonDto[]>(data);
      } else {
        this.action = false;
        this.router.navigateByUrl('');
      }
    });
  }

  sum() {
    this.badmintonService.sumBill(this.username).subscribe(data => {
      this.sumCart = data;
    });
  }

  updateQAmount(cart: CartDto) {
    this.badmintonService.updateAmount(cart, this.username).subscribe(value => {
      this.ngOnInit();
    });
  }

  removeProduct(product: CartDto) {
    this.nameDelete = product.name;
    Swal.fire({
      title: 'Bạn chắc chắn muốn xóa sản phẩm?',
      text: this.nameDelete,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Có, xóa',
      cancelButtonText: 'Không'
    }).then((result) => {
      if (result.isConfirmed) {
        this.badmintonService.removeProduct(product.id).subscribe(value => {
          Swal.fire(
            'Đã xóa!',
            'Sản phẩm ' + this.nameDelete + 'đã bị xóa.',
            'success'
          );
          this.ngOnInit();
        });
      }
    });
  }

  payment(): void {
    render(
      {
        id: '#myPaypal',
        value: '100.00',
        currency: 'USD',
        onApprove: (details) => {
          alert('thành công');
        }
      }
    );

  }
}
