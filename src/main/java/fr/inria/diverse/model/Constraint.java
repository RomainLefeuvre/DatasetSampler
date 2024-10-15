package fr.inria.diverse.model;

import java.util.function.Function;

import fr.inria.diverse.model.metadata.Metadata;

public class Constraint {

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

    

    public Metadata targetedMetadata;

    public Constraint(Function<Object, Boolean> constraint, Metadata targetedMetadata) {
        this.constraint = constraint;
        //Todo add check
        this.targetedMetadata = targetedMetadata;
    }

    

}
