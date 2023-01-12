import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {IBadmintonDto} from '../../dto/i-badminton-dto';
import {BadmintonService} from '../../service/badminton.service';
import {Title} from '@angular/platform-browser';
import {NavigationEnd, Router} from '@angular/router';
import Swal from 'sweetalert2';
import {TokenStorageService} from '../../service/token-storage.service';


@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  pageSize = 4;
  productList$: Observable<IBadmintonDto[]> | undefined;
  total$: Observable<number>;
  productNameSearch = '';
  action: boolean;
  username: string;
  // shoe-list
  pageSizeShoe = 4;
  shoeList$: Observable<IBadmintonDto[]> | undefined;
  totalShoe$: Observable<number>;
  shoeNameSearch = '';
  shoeAction: boolean;

  constructor(private badmintonService: BadmintonService,
              private title: Title,
              private router: Router,
              private tokenStorageService: TokenStorageService) {
    this.title.setTitle('Trang chủ');
  }

  ngOnInit(): void {
    this.paginate(this.productNameSearch, this.pageSize);
    this.shoePaginate(this.shoeNameSearch, this.pageSizeShoe);
    this.router.events.subscribe((event) => {
      if (!(event instanceof NavigationEnd)) {
        return;
      }
      window.scrollTo(0, 0);
    });
    this.username = this.tokenStorageService.getUser().username;
  }

  paginate(productNameSearch, pageSize) {
    this.badmintonService.findAllListBadminton(productNameSearch, pageSize).subscribe(data => {
      if (data != null) {
        this.action = true;
        this.productList$ = new BehaviorSubject<IBadmintonDto[]>(data.content);
        this.total$ = new BehaviorSubject<number>(data.totalElements);
      } else {
        this.action = false;
      }
    });
  }

  nextPage() {
    this.pageSize += 4;
    this.paginate(this.productNameSearch, this.pageSize);
  }

  // shoe-list
  shoePaginate(shoeNameSearch, pageSizeShoe) {
    this.badmintonService.findAllListShoe(shoeNameSearch, pageSizeShoe).subscribe(data => {
      if (data != null) {
        this.shoeAction = true;
        this.shoeList$ = new BehaviorSubject<IBadmintonDto[]>(data.content);
        this.totalShoe$ = new BehaviorSubject<number>(data.totalElements);
      } else {
        this.shoeAction = false;
      }
    });
  }

  shoeNextPage() {
    this.pageSizeShoe += 4;
    this.shoePaginate(this.shoeNameSearch, this.pageSizeShoe);
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
      }).then(value => {
        location.reload();
      });
    }, error => {
      console.log(error);
    });
  }
}
