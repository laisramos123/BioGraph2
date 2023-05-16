import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Animal } from './animal';

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

  private baseUrl = "http://localhost:8080/animal-nodes"
  constructor(private http: HttpClient) { }

  getPosicaoGrafo(): Observable<Animal>{
    return this.http.get<Animal>(`this.baseUrl`);
  }

}
