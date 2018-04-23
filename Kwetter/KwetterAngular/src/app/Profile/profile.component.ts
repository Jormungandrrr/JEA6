import { Component, OnInit } from '@angular/core';
import {Profile} from '../Models/Profile';
import { ActivatedRoute } from '@angular/router';
import {ProfileService} from '../Services/ProfileService';

@Component({
  selector: 'app-profile' ,
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  username: string;
  profile: Profile;
  content: string;
  loggedIn: boolean;

  public ngOnInit() {
    this.route.params.subscribe(params => { this.username = params['username']; });
    this.profileService.getProfile(this.username).subscribe(data => {
      if (data != null) {
        this.profile = data;
      }
    });
  }

  PlaceMessage() {
    this.profileService.placeMessage(Number(localStorage.getItem('profileId')), this.profile.id, this.content).subscribe();
  }

  constructor(private route: ActivatedRoute, private profileService: ProfileService) {
    this.loggedIn = Boolean(localStorage.getItem('loggedIn'));
  }
}
