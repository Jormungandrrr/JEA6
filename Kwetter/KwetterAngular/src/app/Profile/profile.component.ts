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
  searchQuery: string;
  ws: WebSocket;

  public ngOnInit() {
    this.route.params.subscribe(params => { this.username = params['username']; });
    this.profileService.getProfile(this.username).subscribe(data => {
      if (data != null) {
        this.profile = data;
      }
      this.ws = new WebSocket('ws://localhost:8080/Kwetter/messageSocket/' + this.username);
      this.SetWebsocket();
    });
  }

  PlaceMessage() {
    this.profileService.placeMessage(this.profile.id, this.content).subscribe(data => {
      if (data != null) {
        this.profile.messages.push(data);
        this.ws.send(data.content + ' Posted by ' + localStorage.getItem('currentProfile'));
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
        this.profile.following = data.following;
      }
    });
  }

  UpdateProfile() {
    this.profileService.UpdateProfile(this.profile).subscribe();
  }

  LikeMessage(MessageID: number) {
    this.messageService.LikeMessage(MessageID, this.profile.id).subscribe();
  }

  FlagMessage(MessageID: number) {
    this.messageService.FlagMessage(MessageID, this.profile.id).subscribe();
  }

  onSearch(): void {
    this.profileService.searchUsers(this.searchQuery).subscribe((data) => {
      this.profile.messages = data;
    });
  }

  private SetWebsocket() {
    this.ws.onopen = (e) => {
      console.log('Connected');
    };
    this.ws.onerror = (e) => {
      alert(e);
    }

    this.ws.onmessage = (e) => {
      console.log('Message posted: ' + e.data);
    };
  }

  constructor(
    private route: ActivatedRoute,
    private profileService: ProfileService,
    private messageService: MessageService) {
    this.loggedIn = Boolean(localStorage.getItem('loggedIn'));
    this.role = localStorage.getItem('role');
    this.currentUserId = Number(localStorage.getItem('profileId'));
  }
}
