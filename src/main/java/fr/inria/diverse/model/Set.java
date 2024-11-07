package fr.inria.diverse.model;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class Set extends Element{
    private java.util.Set<Element> elements;

    public Set(){
        this.elements = new HashSet<>();
    }

    public Set addElement(Element e){
        this.elements.add(e);
        return this;
    }
   

    public  Set getRandomSubset(int subsetSize) {
        if (subsetSize > this.elements.size()) {
            throw new IllegalArgumentException("Subset size cannot be larger than the size of the original set");
        }
        Element[] originalArray = this.elements.toArray(new Element[0]);
        java.util.Set<Integer> randomIndices = new HashSet<>(subsetSize);
        Random random = new Random();

        // Phase 1: Generate random distinct indices
        while (randomIndices.size() < subsetSize) {
            randomIndices.add(random.nextInt(this.elements.size()));
        }

        // Phase 2: Extract the corresponding elements using those indices
        Set result = new Set();        
        for (int index : randomIndices) {
            result.addElement(originalArray[index]);
        }

        return result;
    }

    public List<Element> getElements(){
        return this.elements.stream().collect(Collectors.toList());
    }
    
}
