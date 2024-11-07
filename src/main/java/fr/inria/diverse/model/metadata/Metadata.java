package fr.inria.diverse.model.metadata;

import java.util.function.BiFunction;
import java.util.function.Function;

import fr.inria.diverse.model.constraint.BoolComparator;
import fr.inria.diverse.model.constraint.BoolConstraint;
import fr.inria.diverse.model.constraint.Constraint;

public class Metadata<T> {
    public String name;
    public Class type;
    
    

    public Metadata(String name, Class t) {
        this.name = name;
        this.type = t;
    }

    private boolean isOfType(Object obj) {
        return type.isInstance(obj);
    }

    public BoolConstraint<T> boolConstraint(Function<T, Boolean> constraint){
        return new BoolConstraint<T>(constraint, this);    }
    
    public BoolComparator<T> boolComparator(BiFunction<T,T,T> comparator){
        return new BoolComparator<>(this ,comparator);
    };

    public MetadataValue<T> createMetadataValue(Object value){
        if (!type.isInstance(value)) {
            throw new ClassCastException("Value " + value + " is not of type " + type.getName());
        }
        return new MetadataValue<>(this,(T) value);

    }
     
    
}
