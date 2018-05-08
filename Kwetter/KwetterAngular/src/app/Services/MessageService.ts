import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Message} from '../Models/Message';

@Injectable()
export class MessageService {
  apiUrl = 'http://localhost:8080/Kwetter/api/messages/';

  constructor(private http: HttpClient) {
  }

  LikeMessage(MessageID: number, profileID: number) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const params = new HttpParams()
      .set('profileid', profileID.toString())
    const options = {
      headers,
      params
    };
    return this.http.post<Message>(this.apiUrl + MessageID + '/like' , null, options);
  }

  FlagMessage(MessageID: number, profileID: number) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const params = new HttpParams()
      .set('profileid', profileID.toString())
    const options = {
      headers,
      params
    };
    return this.http.post<Message>(this.apiUrl + MessageID + '/flag' , null, options);
  }
}
