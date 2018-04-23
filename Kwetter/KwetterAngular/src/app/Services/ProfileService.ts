import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
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

  placeMessage(profileID: number, message: string): Observable<Profile> {
    return this.http.get<Profile>(this.apiUrl + profileID + '/message?content=' + message);
  }
}
