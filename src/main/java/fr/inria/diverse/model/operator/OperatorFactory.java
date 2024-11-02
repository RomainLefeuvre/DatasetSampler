package fr.inria.diverse.model.operator;

import fr.inria.diverse.model.constraint.Constraint;
import fr.inria.diverse.model.operator.clustering.PartitionOperator;
import fr.inria.diverse.model.operator.selection.SelectionOperator;
import fr.inria.diverse.model.operator.selection.filter.FilterOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.RandomSelectionOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.SystematicRandomSelectionOperator;
import fr.inria.diverse.model.operator.selection.sampling.manual.ManualSamplingOperator;

public class OperatorFactory {

    public static FilterOperator filterOperator(Constraint... constraints){
        return new FilterOperator(constraints);
    }

    public static PartitionOperator partitionOperator(SelectionOperator... selectionOperators){
        return new PartitionOperator(selectionOperators);
    }

    public static RandomSelectionOperator randomSelectionOperator(int seed, int cardinality){
        return new RandomSelectionOperator(seed, cardinality);
    }

    public static RandomSelectionOperator randomSelectionOperator( int cardinality){
        return new RandomSelectionOperator(cardinality);
    }

    public static SystematicRandomSelectionOperator systematicRandomSelectionOperator(int cardinality, int pas){
        return new SystematicRandomSelectionOperator(cardinality,pas);
    }

    public static ManualSamplingOperator manualSamplingOperator(int cardinality){
        return new ManualSamplingOperator(cardinality);
    }
    
}
