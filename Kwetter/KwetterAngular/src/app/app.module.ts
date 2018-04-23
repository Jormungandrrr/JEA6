import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ProfileComponent } from './Profile/profile.component';
import { LoginComponent } from './Login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { LoginService } from './Services/LoginService';
import {ProfileService} from './Services/ProfileService';

@NgModule({
  declarations: [AppComponent, ProfileComponent, LoginComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [LoginService, ProfileService],
  bootstrap: [AppComponent],
})

export class AppModule { }
