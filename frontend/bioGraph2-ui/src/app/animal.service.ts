import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  getAnimal(){
    return [
      {
        "id":1,
        "nome":"grama"
      },
      {
        "id":2,
        "nome":"Gazela"
      },
      {
        "id":3,
        "nome":"Zebra"
      },
      {
        "id":4,
        "nome":"Leão"
      },
      {
        "id":5,
        "nome":"Cheta"
      }      
    ];
  }

  constructor() { }
}
