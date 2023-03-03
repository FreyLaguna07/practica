import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { NavsComponent } from './navs/navs.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ContentModule } from './content/content.module';
import {CardModule} from 'primeng/card';
import { BaseModule } from './Base/base.module';

@NgModule({
  declarations: [
    AppComponent,
      NavsComponent,
      DashboardComponent,
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    //Material
    MaterialModule,
    //routing
    ContentModule,
    CardModule,
    BaseModule



  ],
  exports: [
    MaterialModule,
  ],
  providers: [
    //{provide: LOCALE_ID, useValue: 'es'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
