import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseRoutingModule } from './base-routing.module';
import { loginComponent } from './login/login.component';
import { MaterialModule } from '../material/material.module';

@NgModule({
  declarations: [
    loginComponent,
  ],
  imports: [
    CommonModule,
    BaseRoutingModule,
    MaterialModule,
   ],
  exports: [
    BaseRoutingModule,
    loginComponent
  ],
  providers: [],
})
export class BaseModule {}
