package fr.inria.diverse.model.constraint;

import java.util.function.Function;

import fr.inria.diverse.model.Element;
import fr.inria.diverse.model.metadata.Metadata;

public class BoolConstraint<T> extends Constraint<T> {
    public static <T extends Comparable<T>>  Function<T, Boolean> greaterThan(T x) {
        return n -> n.compareTo(x) >0;
    }
   
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

    private Constraint<?> or;

    private Constraint<?> and;


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
    
    public <K> BoolConstraint<K> or(BoolConstraint<K> c){
        this.or =  c;
        return  c ;
    }

    public <K> BoolConstraint<K> and(BoolConstraint<K> c){
        this.and = c;
        return c ;
    }

    


    

    

}
