import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import {Player} from '../Models/Player';

@Injectable()
export class LoginService {
  apiUrl = 'http://localhost:8080/Raidbot/playerservice/login';

  constructor(private http: HttpClient) {
  }

  Login(username: string, password: string): Observable<HttpResponse<Player>> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
  });
    const params = new HttpParams()
      .set('username', username)
      .set('password', password)
    return this.http.get<Player>(this.apiUrl, {headers, params, observe : 'response'});
  }
}
