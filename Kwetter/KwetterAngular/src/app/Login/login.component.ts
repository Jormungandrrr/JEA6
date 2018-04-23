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
  }

  Login() {
   this.loginService.Login(this.username, this.password).subscribe(data => {
     if (data != null) {
       localStorage.setItem('email', data.email);
       localStorage.setItem('role', data.role.name);
       localStorage.setItem('profileId', data.profile.id.toString());
       localStorage.setItem('loggedIn', String(true));
       this.router.navigate(['/profile/', data.username]);
     }
   });
  }
}
