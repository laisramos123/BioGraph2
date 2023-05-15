import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GrafoRoutingModule } from './grafo-routing.module';
import { GrafoComponent } from './grafo/grafo.component';


@NgModule({
  declarations: [
    GrafoComponent
  ],
  imports: [
    CommonModule,
    GrafoRoutingModule
  ]
})
export class GrafoModule { }
