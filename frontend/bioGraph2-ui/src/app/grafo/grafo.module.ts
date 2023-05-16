import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { GrafoRoutingModule } from './grafo-routing.module';
import { GrafoComponent } from './grafo/grafo.component';


@NgModule({
  declarations: [
    GrafoComponent
  ],
  imports: [
    CommonModule,
    GrafoRoutingModule,
    FormsModule
  ]
})
export class GrafoModule { }
