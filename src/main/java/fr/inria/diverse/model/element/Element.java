package fr.inria.diverse.model.element;

import java.util.HashMap;
import java.util.List;

import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.metadata.MetadataValue;

public abstract class Element {

    public HashMap<Metadata<?>,MetadataValue> metadata = new HashMap<>();

    public <T> MetadataValue<T>  getMetadataValue(Metadata<T> m){
        if (!metadata.containsKey(m)){
            //Todo Add type verification
            throw new RuntimeException("Missing metadata "+m);
        }
        return this.getMetadataValue(m);
    };

    public void addMetadataValues(List<MetadataValue<?>> metadataValues){
        for(MetadataValue<?> metadataValue : metadataValues){
            metadata.put(metadataValue.getMetadata(), metadataValue);
        }
    }


    public HashMap<Metadata<?>,MetadataValue> getMetadataValue(){
        return this.metadata;
    }

    
}
