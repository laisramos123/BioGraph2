import { Component, OnInit } from '@angular/core';
import { Grafo } from '../model/grafo';
import { Animal } from './animal';
import { AnimalService } from 'src/app/animal.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-grafo',
  templateUrl: './grafo.component.html',
  styleUrls: ['./grafo.component.css']
})
export class GrafoComponent implements OnInit {
[x: string]: any;

  animal: any;
  animais: any;
  animalSelecionado: string = '';

  selectedId!: number;
  mostrarValor: boolean = false;

  constructor(private animalService: AnimalService,
    private http: HttpClient) {
    this.animais=animalService.getAnimal();
  }

  ngOnInit(): void {
    this.animais=this.animal.service.getAnimal();
  }

  cadeia (event: any) {
    this.animalSelecionado = event.target.value;
    if(this.animalSelecionado == '1'){
      this.animalSelecionado = 'Nível trófico 1'
    }
    else if(this.animalSelecionado == '2'){
      this.animalSelecionado = 'Nível trófico 2'
    }
    else if(this.animalSelecionado == '3'){
      this.animalSelecionado = 'Nível trófico 2'
    }
    else if(this.animalSelecionado == '4'){
      this.animalSelecionado = 'Nível trófico 3'
    }
    else if(this.animalSelecionado == '5'){
      this.animalSelecionado = 'Nível trófico 3'
    }
  }
}
