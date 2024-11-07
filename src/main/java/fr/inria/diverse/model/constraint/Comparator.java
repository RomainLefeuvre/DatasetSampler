package fr.inria.diverse.model.constraint;

import fr.inria.diverse.model.Element;
import fr.inria.diverse.model.metadata.Metadata;

public abstract  class  Comparator<T> {
    public Metadata<T> targetedMetadata;

    public abstract Element compare( Element a,Element b);

    public Comparator(Metadata<T> targetedMetadata) {
        this.targetedMetadata = targetedMetadata;
    }
    
    
}
