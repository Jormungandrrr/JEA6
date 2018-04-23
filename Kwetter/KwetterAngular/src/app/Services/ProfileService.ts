import { Injectable } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import {Profile} from './../Models/Profile';

@Injectable()
export class ProfileService {
  apiUrl = 'http://localhost:8080/Kwetter/api/profiles/';
  constructor(private http: HttpClient) {
  }

  getProfile(username: string): Observable<Profile> {
    return this.http.get<Profile>('http://localhost:8080/Kwetter/api/accounts/' + username + '/profile');
  }

  placeMessage(PosterID: number, profileID: number, message: string) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const params = new HttpParams()
      .set('ownerid', PosterID.toString())
      .set('content', message);
    const options = {
      headers,
      params
    };
    return this.http.post(this.apiUrl + profileID + '/message', null, options);
  }
}
