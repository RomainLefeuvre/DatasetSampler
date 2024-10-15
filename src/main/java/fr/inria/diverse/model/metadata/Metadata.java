package fr.inria.diverse.model.metadata;

import java.util.function.Function;

import fr.inria.diverse.model.Constraint;

public class Metadata {
    String name;
    Class type;
    
    

    public Metadata(String name, Class t) {
        this.name = name;
        this.type = t;
    }

    private boolean isOfType(Object obj) {
        return type.isInstance(obj);
    }

    public Constraint constraint(Function<Object, Boolean> constraint){
        return new Constraint((obj) -> {
            if (!isOfType(obj)) {
                throw new IllegalArgumentException("Object is not of the expected type: " + type);
            }
            return constraint.apply(obj);
        }, this);    }
    
}
