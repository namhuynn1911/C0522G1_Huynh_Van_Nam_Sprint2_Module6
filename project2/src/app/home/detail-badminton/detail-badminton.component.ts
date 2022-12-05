import { Component, OnInit } from '@angular/core';

declare function detail(): void;

@Component({
  selector: 'app-detail-badminton',
  templateUrl: './detail-badminton.component.html',
  styleUrls: ['./detail-badminton.component.css']
})
export class DetailBadmintonComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    detail();
  }

}
