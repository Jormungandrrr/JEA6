import { Component } from '@angular/core';
import {LoginService} from '../Services/LoginService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login' ,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
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
       localStorage.setItem('name', data.body.name);
       localStorage.setItem('level', data.body.level.toString());
       this.router.navigate(['/map']);
     }
   });
  }
}
