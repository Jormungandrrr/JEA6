import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import {Account} from './../Models/Account';

@Injectable()
export class LoginService {
  apiUrl = 'http://localhost:8080/Kwetter/api/login';

  constructor(private http: HttpClient) {
  }

  Login(username: string, password: string): Observable<Account> {
    let Params = new HttpParams();
    Params = Params.append('username', username);
    Params = Params.append('password', password);
    return this.http.get<Account>(this.apiUrl, { params: Params });
  }
}
