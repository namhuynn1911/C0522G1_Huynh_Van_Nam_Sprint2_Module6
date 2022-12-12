import { Component, OnInit } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {IBadmintonDto} from '../../dto/i-badminton-dto';
import {BadmintonService} from '../../service/badminton.service';
import {Title} from '@angular/platform-browser';
import {Router} from '@angular/router';

@Component({
  selector: 'app-shoe-list',
  templateUrl: './shoe-list.component.html',
  styleUrls: ['./shoe-list.component.css']
})
export class ShoeListComponent implements OnInit {
  pageSize = 4;
  productList$: Observable<IBadmintonDto[]> | undefined;
  total$: Observable<number>;
  shoeNameSearch = '';
  action: boolean;
  constructor(private badmintonService: BadmintonService,
              private title: Title,
              private router: Router) {
    this.title.setTitle('Trang chủ');
  }

  ngOnInit(): void {
    this.paginate(this.shoeNameSearch, this.pageSize);
  }

  paginate(sheNameSearch, pageSize) {
    this.badmintonService.findAllListBadminton(sheNameSearch, pageSize).subscribe(data => {
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
    this.paginate(this.shoeNameSearch, this.pageSize);
  }
}
