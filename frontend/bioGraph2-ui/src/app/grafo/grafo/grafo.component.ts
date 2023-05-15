import { Component, OnInit } from '@angular/core';
import { Grafo } from '../model/grafo';
import { Animal } from './animal';
import { AnimalService } from 'src/app/animal.service';

@Component({
  selector: 'app-grafo',
  templateUrl: './grafo.component.html',
  styleUrls: ['./grafo.component.css']
})
export class GrafoComponent implements OnInit {

  animal: any
  animais: any

  constructor(service: AnimalService) {
    this.animais=service.getAnimal();
  }

  ngOnInit(): void {
    this.animais=this.animal.service.getAnimal();
  }
}
