import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import {Account} from './../Models/Account';

@Injectable()
export class LoginService {
  apiUrl = 'http://localhost:8080/Kwetter/api/login';

  constructor(private http: HttpClient) {
  }

  Login(username: string, password: string): Observable<HttpResponse<Account>> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': ''
  });
    const params = new HttpParams()
      .set('username', username)
      .set('password', password)
    return this.http.get<Account>(this.apiUrl, {headers, params, observe : 'response'});
  }
}
