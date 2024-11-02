package fr.inria.diverse.model;

import fr.inria.diverse.model.metadata.Metadata;

public class Repository extends Element {
    //Metadata type use as id 
    Metadata<String> id;

    public Repository(Metadata<String> id) {
        this.id = id;
    }
    
}
