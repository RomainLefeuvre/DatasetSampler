package fr.inria.diverse.model;

import java.util.HashMap;

import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.metadata.MetadataValue;

public abstract class Element {
    protected HashMap<Metadata<Object>,MetadataValue> metadata;

    public <T> MetadataValue<T>  getMetadataValue(Metadata<T> m){
        if (!metadata.containsKey(m)){
            //Todo Add type verification
            throw new RuntimeException("Missing metadata "+m);
        }
        return this.getMetadataValue(m);
    };
}
