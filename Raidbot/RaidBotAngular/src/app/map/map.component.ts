import { Component, OnInit } from '@angular/core';
import {Marker} from '../Models/Marker';
import {Raid} from '../Models/Raid';
import {RaidService} from '../Services/RaidService';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css'],
  providers: [RaidService]
})
export class MapComponent implements OnInit {

  mapCanvas = new Marker(52.1326, 5.2913);
  raids: Raid[] = [];

  constructor( private raidService: RaidService) { }

  ngOnInit() {
    this.GetRaids();
  }

  GetRaids() {
    this.raidService.getRaids().subscribe(data => {
      if (data != null) {
        console.log(data);
        this.raids = data;
      }
    });
  }

}
