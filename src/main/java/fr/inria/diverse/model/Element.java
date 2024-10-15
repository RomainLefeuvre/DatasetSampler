package fr.inria.diverse.model;

import java.util.HashMap;

import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.metadata.MetadataValue;

public abstract class Element {
    protected HashMap<Metadata,MetadataValue> metadata;

    MetadataValue getMetadataValue(Metadata m){
        if (!metadata.containsKey(m)){
            throw new RuntimeException("Missing metadata "+m);
        }
        return this.getMetadataValue(m);
    };
}
