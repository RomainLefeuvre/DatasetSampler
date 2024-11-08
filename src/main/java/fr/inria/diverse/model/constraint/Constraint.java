package fr.inria.diverse.model.constraint;

import fr.inria.diverse.model.element.Element;
import fr.inria.diverse.model.metadata.Metadata;

public abstract  class  Constraint<T> {
    public Metadata<T> targetedMetadata;

    public abstract boolean isSatisfied( Element e);

    public Constraint(Metadata<T> targetedMetadata) {
        this.targetedMetadata = targetedMetadata;
    }
    
    
}
