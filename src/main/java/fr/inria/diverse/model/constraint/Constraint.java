package fr.inria.diverse.model.constraint;

import java.util.function.Function;

import fr.inria.diverse.model.Element;
import fr.inria.diverse.model.metadata.Metadata;

public abstract class Constraint {
    public Metadata targetedMetadata;

    public abstract boolean isSatisfied( Element e);

    public Constraint(Metadata targetedMetadata) {
        this.targetedMetadata = targetedMetadata;
    }
    
    
}
