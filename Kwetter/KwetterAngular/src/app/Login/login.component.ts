import { Component } from '@angular/core';
import {LoginService} from '../Services/LoginService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login' ,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  username;
  password;

  constructor(private loginService: LoginService, private router: Router ) {
    localStorage.clear();
  }

  Login() {
   this.loginService.Login(this.username, this.password).subscribe(data => {
     if (data != null) {
       console.log(data.headers);
       localStorage.setItem('email', data.body.email);
       localStorage.setItem('currentProfile', data.body.profile.name);
       localStorage.setItem('role', data.body.role.name);
       localStorage.setItem('profileId', data.body.profile.id.toString());
       localStorage.setItem('loggedIn', String(true));
       localStorage.setItem('token', data.body.token);
       this.router.navigate(['/profile/', data.body.username]);
     }
   });
  }
}
