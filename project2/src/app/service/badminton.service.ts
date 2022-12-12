import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SearchResult} from '../dto/search-result';
import {IBadmintonDto} from '../dto/i-badminton-dto';
import {IResultShoe} from '../dto/i-result-shoe';

@Injectable({
  providedIn: 'root'
})
export class BadmintonService {
  URL_API = `${environment.api_url}`;
  httpOptions: any;
  isLoggedIn: boolean | undefined;

  constructor(private httpClient: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    };
}


  login(obj: { username: string; password: string; }): Observable<any> {
    return this.httpClient.post(this.URL_API + '/badminton/login', {
      username: obj.username,
      password: obj.password
    }, this.httpOptions);
  }
  findAllListBadminton(name: string, size: number): Observable<SearchResult<IBadmintonDto>> {
    const API_URL_HOME = this.URL_API + '/badminton/list/home?name=' + name + '&size=' + size;
    console.log(API_URL_HOME);
    return this.httpClient.get<SearchResult<IBadmintonDto>>(API_URL_HOME);
  }

  findAllListShoe(name: string, size: number): Observable<SearchResult<IBadmintonDto>> {
    const API_URL_SHOE = this.URL_API + '/badminton/list/shoe?name=' + name + '&size=' + size;
    console.log(API_URL_SHOE);
    return this.httpClient.get<SearchResult<IBadmintonDto>>(API_URL_SHOE);
  }

  findById(id: number): Observable<IBadmintonDto> {
    return this.httpClient.get<IBadmintonDto>(this.URL_API + '/badminton/detail/' + id);
  }

}
