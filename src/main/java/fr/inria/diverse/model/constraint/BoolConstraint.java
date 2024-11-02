package fr.inria.diverse.model.constraint;

import java.util.function.Function;

import fr.inria.diverse.model.Element;
import fr.inria.diverse.model.metadata.Metadata;

public class BoolConstraint<T> extends Constraint<T> {
    public BoolConstraint(Metadata<T> targetedMetadata) {
        super(targetedMetadata);
        //TODO Auto-generated constructor stub
    }

    public BoolConstraint(Function<T, Boolean> constraint, Metadata<T> targetedMetadata) {
        super(targetedMetadata);
        this.constraint = constraint;
        //Todo add check
        this.targetedMetadata = targetedMetadata;
    }



    //Todo Implement properly bool algebra.
    Function<T, Boolean> constraint;

    private Constraint<Object> or;

    private Constraint<Object> and;


    public boolean isSatisfied( Element e){
        if(or != null && and != null){
            throw new RuntimeException("Both and & or defined");
        }
        boolean constraintResult = this.constraint.apply((T) e.getMetadataValue(targetedMetadata));
        if(or != null){
            return constraintResult || or.isSatisfied(e);
        }
        if(and != null){
            return constraintResult && or.isSatisfied(e);
        }

        return constraintResult;

    }
    
    public <K> Constraint<K> or(Constraint<K> c){
        this.or = (Constraint<Object>) c;
        return c ;
    }

    public <K> Constraint<K> and(Constraint<K> c){
        this.and = (Constraint<Object>) c;
        return c ;
    }

    


    

    

}
