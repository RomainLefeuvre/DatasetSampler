package fr.inria.diverse.model.operator.clustering;

import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.constraint.Constraint;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.selection.SelectionOperator;
import fr.inria.diverse.model.operator.selection.filter.FilterOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.RandomSelectionOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.SystematicRandomSelectionOperator;

public  class PartitionOperator extends Operator {
    Operator[] operators;

    public PartitionOperator(Operator... operators) {
        this.operators = operators;
        for (Operator Operator : operators){
            Operator.input(input);
        }
    }

    


    @Override
    public Operator execute() {
        this.output = new Set();

        for(Operator selectionOperator : operators ){
            selectionOperator.execute();
            this.output.addElement(selectionOperator.output());
        }
        
        return this;
    }



    public class ClusteringSubOperators{

        public static SelectionOperator randomSelectionOperator(int seed, int cardinality){
        return new RandomSelectionOperator(seed, cardinality);
    }

    public static SelectionOperator randomSelectionOperator( int cardinality){
        return new RandomSelectionOperator(cardinality);
       
    }

    public static SelectionOperator systematicRandomSelectionOperator(int cardinality, int pas){
        return new SystematicRandomSelectionOperator(cardinality,pas);
      
    }

    public static SelectionOperator filterOperator(Constraint constraint){
        return new FilterOperator(constraint);
      
    }
    }


   
    
    

}
