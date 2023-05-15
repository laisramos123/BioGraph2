package com.example.biograph2.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AnimalNodeService {

    private final AnimalNodeRepository animalNodeRepository;

    @Autowired
    public AnimalNodeService(AnimalNodeRepository animalNodeRepository) {
        this.animalNodeRepository = animalNodeRepository;
    }

    public AnimalNode createAnimalNode(AnimalNode animalNode) {
        // Lógica de validação, manipulação de dados, etc.
        return animalNodeRepository.save(animalNode);
    }

    public AnimalNode getAnimalNode(String id) {
        // Lógica de busca, validações, etc.
        return animalNodeRepository.findById(id).orElse(null);
    }
    public void printPaths(List<AnimalNode> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(AnimalNode::getAnimalName)
                    .collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank()
                    ? "%s : %s".formatted(node.getAnimalName(), node.getDistance())
                    : "%s -> %s : %s".formatted(path, node.getAnimalName(), node.getDistance()))
            );
        });
    }
    public void adicionarAnimais() {
        AnimalNode nodeA = new AnimalNode("A");
        AnimalNode nodeB = new AnimalNode("B");
        AnimalNode nodeC = new AnimalNode("C");
        // Adicione os outros animais conforme necessário

        // Adicione os nós adjacentes aos animais
        nodeA.addAdjacentAnimalNode(nodeB, 2);
        nodeA.addAdjacentAnimalNode(nodeC, 4);
        // Adicione as outras arestas conforme necessário

        // Salve os animais no repositório
        animalNodeRepository.save(nodeA);
        animalNodeRepository.save(nodeB);
        animalNodeRepository.save(nodeC);
        // Salve os outros animais conforme necessário
    }


}

