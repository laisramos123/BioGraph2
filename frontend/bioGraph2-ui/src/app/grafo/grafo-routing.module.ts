import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GrafoComponent } from './grafo/grafo.component';

const routes: Routes = [
  { path: '', component: GrafoComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GrafoRoutingModule { }
