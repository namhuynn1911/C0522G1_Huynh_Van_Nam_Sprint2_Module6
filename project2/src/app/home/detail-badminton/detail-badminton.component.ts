import { Component, OnInit } from '@angular/core';
import {BadmintonService} from '../../service/badminton.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {IBadmintonDto} from '../../dto/i-badminton-dto';
import {async} from '@angular/core/testing';

declare function detail(): void;

@Component({
  selector: 'app-detail-badminton',
  templateUrl: './detail-badminton.component.html',
  styleUrls: ['./detail-badminton.component.css']
})
export class DetailBadmintonComponent implements OnInit {
product: IBadmintonDto;

  constructor(private badmintonService: BadmintonService,
              private activatedRoute: ActivatedRoute,
              private title: Title,
              private router: Router) { }

  ngOnInit(): void {
    this.title.setTitle('Chi tiết sản phẩm');
    const id = Number(this.activatedRoute.snapshot.params.id);
    this.badmintonService.findById(id).subscribe(value => {
      console.log(value);
      this.product = value;
    });
    // detail();
    // window.location.reload();
  }
}
