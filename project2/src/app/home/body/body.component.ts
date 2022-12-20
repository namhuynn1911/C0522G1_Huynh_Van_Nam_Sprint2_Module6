import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {IBadmintonDto} from '../../dto/i-badminton-dto';
import {BadmintonService} from '../../service/badminton.service';
import {Title} from '@angular/platform-browser';
import {NavigationEnd, Router} from '@angular/router';


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
  // shoe-list
  pageSizeShoe = 4;
  shoeList$: Observable<IBadmintonDto[]> | undefined;
  totalShoe$: Observable<number>;
  shoeNameSearch = '';
  shoeAction: boolean;

  constructor(private badmintonService: BadmintonService,
              private title: Title,
              private router: Router) {
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
    this.pageSize += 3;
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
    this.pageSizeShoe += 3;
    this.shoePaginate(this.shoeNameSearch, this.pageSizeShoe);
  }

  addToCart(item: IBadmintonDto) {
    this.badmintonService.updateCart(item).subscribe(() => {
      // this.messageService.add({severity: 'success', summary: 'Success', detail: 'Add successfully'});
    });
  }
}
