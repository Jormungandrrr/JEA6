import { Component, OnInit } from '@angular/core';
import {Profile} from '../Models/Profile';
import { ActivatedRoute } from '@angular/router';
import {ProfileService} from '../Services/ProfileService';
import {MessageService} from '../Services/MessageService';

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
  role: string;
  currentUserId: number;

  public ngOnInit() {
    this.route.params.subscribe(params => { this.username = params['username']; });
    this.profileService.getProfile(this.username).subscribe(data => {
      if (data != null) {
        this.profile = data;
      }
    });
  }

  PlaceMessage() {
    this.profileService.placeMessage(this.currentUserId, this.profile.id, this.content).subscribe(data => {
      if (data != null) {
        this.profile.messages.push(data);
      }
    });
  }

  LikeProfile() {
    this.profileService.LikeProfile(this.currentUserId, this.profile.id).subscribe(data => {
      if (data != null) {
        this.profile.following.push(data);
      }
    });
  }

  UnLikeProfile() {
    this.profileService.UnLikeProfile(this.currentUserId, this.profile.id).subscribe(data => {
      if (data != null) {
        const index: number = this.profile.following.indexOf(data);
        if (index !== -1) {
          this.profile.following.splice(index, 1);
        }
      }
    });
  }

  LikeMessage() {
  }

  constructor(private route: ActivatedRoute, private profileService: ProfileService, private messageService: MessageService) {
    this.loggedIn = Boolean(localStorage.getItem('loggedIn'));
    this.role = localStorage.getItem('role');
    this.currentUserId = Number(localStorage.getItem('profileId'));
  }
}
