package com.example.biograph2.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.*;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalNode implements Comparable<AnimalNode> {
    @Id
    private  String animal_name; //?nome do animal
    private Integer distance= Integer.MAX_VALUE; //?distância mínima desse nó que irá começar com Integer.MAX_VALUE para simular o infinito
    private List<AnimalNode> shortestPath = new LinkedList<>(); //?Lista que armazena o menor caminho do nó origem que será posteriormente atualizado pelo algoritimo de Dijkstra
    private Map<AnimalNode, Integer> adjacentAnimailsNodes = new HashMap<>(); //?Um map que armazena os nós adjacentes/vizinhos desse nó e o peso da aresta que os separa


    public void  addAdjacentAnimalNode(AnimalNode node, int weight){ //?Usa um nó e o peso da aresta que os separa
        adjacentAnimailsNodes.put(node,weight);
    }
    @Override //?Sobrescrição do método compareTo, pois usaremos uma fila de prioridade para puxar o nó instável com a menor distância
    public  int compareTo(AnimalNode node){
        return Integer.compare(this.distance, node.getDistance()) ;
    }

    public void CalculateShortestPath(AnimalNode source){
        source.setDistance(0);
        Set<AnimalNode> settledNodes = new HashSet<>();// ?nos visitados
        Queue<AnimalNode> unsettledNodes = new PriorityQueue<>(Collections.singleton(source)); //?nós não visitados, que será uma fila de prioridade, e o nó origem será add a ele desde o início
        while(!unsettledNodes.isEmpty()){ //? Logo, enquanto esta fila não estiver vazia
            AnimalNode currentNode = unsettledNodes.poll(); //? o que vamos fazer é puxar o nó com a distância mínima dele
            currentNode.getAdjacentAnimailsNodes()
                    .entrySet().stream()
                    .filter(entry -> !settledNodes.contains(entry.getKey())) //? e
                    .forEach(entry ->{ //? e então faremos um loop sobre seus nós adjacentes, precisamente para cada nó adjacente
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);  //? que não foi visitado, o que significa não temos uma distância mínima decisiva para ele, e atualizaremos a distância desse nó e o  caminho mais curto por meio do método evaluateDistanc
                        unsettledNodes.add(entry.getKey()); //? E então iremos inserir este nó na fila de nós não resolvidos
                    });
            settledNodes.add(currentNode); //? Depois de passarmos por todos os nós adjacentes do nó que extraímos, adicionamos o nó com o qual estamos trabalhando no momento ao conjunto de nós estabelecidos
        }
    }

    public void evaluateDistanceAndPath(AnimalNode adjacentNode, Integer edgeWeight, AnimalNode sourceNode){
        Integer newDistance = sourceNode.getDistance() + edgeWeight; //? Precisamos comparara soma do peso da aresta e a distância do nó de origem que ele conecta com a distância destino
        if (newDistance < adjacentNode.getDistance()){ //? Portanto, se a distância calculada for menor que a do nó que estamos tentando alcanças, encontramos um caminho menor e melhor ligando esse nó à origem
            adjacentNode.setDistance(newDistance);//? Logo atualizaremos a distância e o caminho para refletir o que acabamos de calcular
            adjacentNode.setShortestPath(Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList()); //? Para atualizar o caminho, basta adicionar o nó em que estamos atualmente ao caminho em questão e pronto
        }
    }
}
