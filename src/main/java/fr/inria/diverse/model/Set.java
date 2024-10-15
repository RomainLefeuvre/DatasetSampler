package fr.inria.diverse.model;

import java.util.List;

public class Set extends Element{
    List<Element> elements;

    public Set(List<Element> elements) {
        this.elements = elements;
    }
    
}
