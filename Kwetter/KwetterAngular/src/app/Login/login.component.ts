import { Component } from '@angular/core';
import {LoginService} from '../Services/LoginService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login' ,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  title = 'Login';
  username;
  password;


  constructor(private loginService: LoginService, private router: Router ) {
  }

  Login() {
   this.loginService.Login(this.username, this.password).subscribe(data => {
     if (data != null) {
       this.router.navigate(['/profile/', data.username]);
     }
   });
  }
}
