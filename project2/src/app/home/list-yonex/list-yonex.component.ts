import { Component, OnInit } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {IBadmintonDto} from '../../dto/i-badminton-dto';
import {BadmintonService} from '../../service/badminton.service';
import {Title} from '@angular/platform-browser';
import {NavigationEnd, Router} from '@angular/router';
import Swal from 'sweetalert2';
import {TokenStorageService} from '../../service/token-storage.service';

@Component({
  selector: 'app-list-yonex',
  templateUrl: './list-yonex.component.html',
  styleUrls: ['./list-yonex.component.css']
})
export class ListYonexComponent implements OnInit {
  pageSize = 4;
  productList$: Observable<IBadmintonDto[]> | undefined;
  total$: Observable<number>;
  productNameSearch = '';
  action: boolean;
  username: string;
  constructor(private badmintonService: BadmintonService,
              private title: Title,
              private router: Router,
              private tokenStorageService: TokenStorageService) {
    this.title.setTitle('Trang chủ');
  }

  ngOnInit(): void {
    this.paginate(this.productNameSearch, this.pageSize);
    this.router.events.subscribe((event) => {
      if (!(event instanceof NavigationEnd)) {
        return;
      }
      window.scrollTo(0, 0);
    });
    this.username = this.tokenStorageService.getUser().username;
  }

  paginate(productNameSearch, pageSize) {
    this.badmintonService.findAllListYonex(productNameSearch, pageSize).subscribe(data => {
      if (data != null) {
        this.action = true;
        this.productList$ = new BehaviorSubject<IBadmintonDto[]>(data.content);
        this.total$ = new BehaviorSubject<number>(data.totalElements);
      } else {
        this.action = false;
        this.router.navigateByUrl('');
      }
    });
  }

  nextPage() {
    this.pageSize += 3;
    this.paginate(this.productNameSearch, this.pageSize);
  }

  addToCart(item: IBadmintonDto) {
    this.badmintonService.updateCart(item, this.username).subscribe(() => {
      // this.messageService.add({severity: 'success', summary: 'Success', detail: 'Add successfully'});
      const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 2000,
        timerProgressBar: true,
        didOpen: (toast) => {
          toast.addEventListener('mouseenter', Swal.stopTimer);
          toast.addEventListener('mouseleave', Swal.resumeTimer);
        }
      });

      Toast.fire({
        icon: 'success',
        title: 'Thêm vào giỏ hàng thành công!'
      });
    }, error => {
      console.log(error);
    });
  }
}
