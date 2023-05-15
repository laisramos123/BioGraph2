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

    private  String animalName;
    private Integer distance= Integer.MAX_VALUE;
    private List<AnimalNode> shortestPath = new LinkedList<>();
    private Map<AnimalNode, Integer> adjacentAnimailsNodes = new HashMap<>();

    public AnimalNode(String f) {
    }


    public void  addAdjacentAnimalNode(AnimalNode node, int weight){
        adjacentAnimailsNodes.put(node,weight);
    }
    @Override
    public  int compareTo(AnimalNode node){
        return Integer.compare(this.distance, node.getDistance()) ;
    }

    public void CalculateShortestPath(AnimalNode source){
        source.setDistance(0);
        Set<AnimalNode> settledNodes = new HashSet<>();
        Queue<AnimalNode> unsettledNodes = new PriorityQueue<>(Collections.singleton(source));
            AnimalNode currentNode = unsettledNodes.poll();
            currentNode.getAdjacentAnimailsNodes()
                    .entrySet().stream()
                    .filter(entry -> !settledNodes.contains(entry.getKey()))
                    .forEach(entry ->{
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                        unsettledNodes.add(entry.getKey());
                    });
            settledNodes.add(currentNode);
        }


    public void evaluateDistanceAndPath(AnimalNode adjacentNode, Integer edgeWeight, AnimalNode sourceNode){
        Integer newDistance = sourceNode.getDistance() + edgeWeight;
        if (newDistance < adjacentNode.getDistance()){
            adjacentNode.setDistance(newDistance);
            adjacentNode.setShortestPath(Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList());
        }
    }
}
