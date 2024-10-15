package fr.inria.diverse.model;

import fr.inria.diverse.model.metadata.Metadata;

public class Repository extends Element {
    //Metadata type use as id 
    Metadata id;

    public Repository(Metadata id) {
        this.id = id;
    }
    
}
