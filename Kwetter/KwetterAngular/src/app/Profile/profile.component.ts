import { Component, OnInit } from '@angular/core';
import {Profile} from '../Models/Profile';
import { ActivatedRoute } from '@angular/router';
import {ProfileService} from '../Services/ProfileService';
import {Message} from '../Models/Message';

@Component({
  selector: 'app-profile' ,
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit{
  username: string;
  profile: Profile;
  content: string;
  public ngOnInit() {
    this.route.params.subscribe(params => {
      this.username = params['username'];
    });
    this.profileService.getProfile(this.username).subscribe(data => {
      console.log(data);
      if (data != null) {
        this.profile = data;
      }
    });
  }
  PlaceMessage() {
    this.profileService.placeMessage(this.profile.id, this.content).subscribe(data => {

    });
  }
  constructor(private route: ActivatedRoute, private profileService: ProfileService) { }
}
