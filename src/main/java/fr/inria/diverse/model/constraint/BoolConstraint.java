package fr.inria.diverse.model.constraint;

import java.util.function.Function;

import fr.inria.diverse.model.Element;
import fr.inria.diverse.model.metadata.Metadata;

public class BoolConstraint extends Constraint {
    public BoolConstraint(Metadata targetedMetadata) {
        super(targetedMetadata);
        //TODO Auto-generated constructor stub
    }

    public BoolConstraint(Function<Object, Boolean> constraint, Metadata targetedMetadata) {
        super(targetedMetadata);
        this.constraint = constraint;
        //Todo add check
        this.targetedMetadata = targetedMetadata;
    }



    //Todo Implement properly bool algebra.
    Function<Object, Boolean> constraint;

    private Constraint or;

    private Constraint and;


    public boolean isSatisfied( Element e){
        if(or != null && and != null){
            throw new RuntimeException("Both and & or defined");
        }
        boolean constraintResult = this.constraint.apply(e.getMetadataValue(targetedMetadata));
        if(or != null){
            return constraintResult || or.isSatisfied(e);
        }
        if(and != null){
            return constraintResult && or.isSatisfied(e);
        }

        return constraintResult;

    }
    
    public Constraint or(Constraint c){
        return this.or = c;
    }

    public Constraint and(Constraint c){
        return this.and = c;
    }

    


    

    

}
