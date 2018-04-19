import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import {Account} from './../Models/Account';

@Injectable()
export class LoginService {
  apiUrl = 'http://localhost:8080/Kwetter/api/login';

  constructor(private http: HttpClient) {
  }

  Login(username: string, password: string): Observable<Account> {
    return this.http.get<Account>(this.apiUrl + '?username=' + username + '&password=' + password);
  }
}
