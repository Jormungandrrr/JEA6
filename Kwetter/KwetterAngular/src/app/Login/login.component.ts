import { Component } from '@angular/core';
import {LoginService} from '../Services/LoginService';

@Component({
  selector: 'app-login' ,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  title = 'Login';
  username;
  password;


  constructor(private loginService: LoginService ) {
  }

  Login() {
   this.loginService.Login(this.username, this.password).subscribe(data => console.log(data));
  }
}
