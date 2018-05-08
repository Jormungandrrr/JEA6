import { Injectable } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import {Profile} from './../Models/Profile';
import {Message} from './../Models/Message';

@Injectable()
export class ProfileService {
  apiUrl = 'http://localhost:8080/Kwetter/api/profiles/';
  constructor(private http: HttpClient) {
  }

  getProfile(username: string): Observable<Profile> {
    return this.http.get<Profile>('http://localhost:8080/Kwetter/api/accounts/' + username + '/profile');
  }

  placeMessage(profileID: number, message: string) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const params = new HttpParams()
      .set('content', message);
    const options = {
      headers,
      params
    };
    return this.http.post<Message>(this.apiUrl + profileID + '/message', null, options);
  }

  LikeProfile(followerID: number, profileID: number) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const params = new HttpParams()
      .set('followerid', followerID.toString());
    const options = {
      headers,
      params
    };
    return this.http.post<Profile>(this.apiUrl + profileID + '/follower', null, options);
  }

  UnLikeProfile(followerID: number, profileID: number) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const params = new HttpParams()
      .set('followerid', followerID.toString());
    const options = {
      headers,
      params
    };
    return this.http.delete<Profile>(this.apiUrl + profileID + '/follower', options);
  }

  UpdateProfile(profile: Profile) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const params = new HttpParams()
      .set('biography', profile.biography)
      .set('location', profile.location)
      .set('photo', profile.photo)
      .set('website', profile.website);
    const options = {
      headers,
      params
    };
    return this.http.post<Profile>(this.apiUrl + profile.id, null, options);
  }
}
