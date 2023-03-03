import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../material/material.module';
import {CardModule} from 'primeng/card';
import { MantenedorEntidadComponent } from './mantenedorEntidad/mantenedorEntidad.component';

@NgModule({
  declarations: [
    MantenedorEntidadComponent

  ],
  imports: [
    CommonModule,
    MaterialModule,
    CardModule,
   ],
  exports: [
  ],
  providers: [],
})
export class ContentModule {}
