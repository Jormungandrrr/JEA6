import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AgmCoreModule } from '@agm/core';
import { FormsModule } from '@angular/forms';
import {CommonModule} from '@angular/common';

import { AppComponent } from './app.component';
import {LoginComponent} from './Login/login.component';
import { MapComponent } from './map/map.component';
import {HttpClientModule} from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MapComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyALfpNH8dhaRgK3WvWnCx_pmA5hWPyOYJs'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
