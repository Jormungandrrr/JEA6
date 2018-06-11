import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {Raid} from './../Models/Raid';

@Injectable()
export class RaidService {
  apiUrl = 'http://localhost:8080/raidbot/raids';

  constructor(private http: HttpClient) {
  }

  getRaids(): Observable<Raid[]> {
    return this.http.get<Raid[]>(this.apiUrl);
  }
}
