package fr.inria.diverse.model.element;

import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.metadata.MetadataValue;

public class Repository extends Element {
    //Metadata type use as id 
    Metadata<String> id;

    public Repository(Metadata<String> id) {
        this.id = id;
    }

    public String getId(){
        return this.getMetadataValue(id).getValue();
    }
    
}
