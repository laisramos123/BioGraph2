package com.example.biograph2;

import com.example.biograph2.model.AnimalNode;
import com.example.biograph2.model.AnimalNodeRepository;
import com.example.biograph2.model.AnimalNodeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BioGraph2Application {

    public static void main(String[] args) {
//        AnimalNode nodeA = new AnimalNode("A");
//        AnimalNode nodeB = new AnimalNode("B");
//        AnimalNode  nodeC = new AnimalNode("C");
//        AnimalNode  nodeD = new AnimalNode("D");
//        AnimalNode  nodeE = new AnimalNode("E");
//        AnimalNode  nodeF = new AnimalNode("F");
//
//        nodeA.addAdjacentAnimalNode(nodeB, 2);
//        nodeA.addAdjacentAnimalNode(nodeC, 4);
//
//        nodeB.addAdjacentAnimalNode(nodeC, 3);
//        nodeB.addAdjacentAnimalNode(nodeD, 1);
//        nodeB.addAdjacentAnimalNode(nodeE, 5);
//
//        nodeC.addAdjacentAnimalNode(nodeD, 2);
//
//        nodeD.addAdjacentAnimalNode(nodeE, 1);
//        nodeD.addAdjacentAnimalNode(nodeF, 4);
//
//        nodeE.addAdjacentAnimalNode(nodeF, 2);
//        AnimalNodeService teste = new AnimalNodeService;
//        teste.printPaths(Arrays.asList(nodeA,nodeB,nodeC,nodeD,nodeF,nodeE));
        SpringApplication.run(BioGraph2Application.class, args);
    }

}
