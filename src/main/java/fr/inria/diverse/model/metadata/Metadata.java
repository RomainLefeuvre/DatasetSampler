package fr.inria.diverse.model.metadata;

import java.util.function.Function;

import fr.inria.diverse.model.constraint.BoolConstraint;
import fr.inria.diverse.model.constraint.Constraint;

public class Metadata<T> {
    String name;
    Class type;
    
    

    public Metadata(String name, Class t) {
        this.name = name;
        this.type = t;
    }

    private boolean isOfType(Object obj) {
        return type.isInstance(obj);
    }

    public BoolConstraint<T> boolConstraint(Function<T, Boolean> constraint){
        return new BoolConstraint<T>(constraint, this);    }

     
    
}
