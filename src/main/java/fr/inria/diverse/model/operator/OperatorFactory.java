package fr.inria.diverse.model.operator;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collector;

import fr.inria.diverse.model.constraint.Comparator;
import fr.inria.diverse.model.constraint.Constraint;
import fr.inria.diverse.model.operator.clustering.PartitionOperator;
import fr.inria.diverse.model.operator.selection.SelectionOperator;
import fr.inria.diverse.model.operator.selection.filter.FilterOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.RandomSelectionOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.SystematicRandomSelectionOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.SystematicSelectionOperator;
import fr.inria.diverse.model.operator.selection.sampling.manual.ManualSamplingOperator;

public class OperatorFactory {

    public static FilterOperator filterOperator(Constraint<?>... constraints){
        return new FilterOperator(constraints);
    }

    public static PartitionOperator partitionOperator(Operator... operators){
        return new PartitionOperator(operators);
    }

    public static RandomSelectionOperator randomSelectionOperator(int seed, int cardinality){
        return new RandomSelectionOperator(seed, cardinality);
    }

    public static RandomSelectionOperator randomSelectionOperator( int cardinality){
        return new RandomSelectionOperator(cardinality);
    }

    public static SystematicSelectionOperator systematicSelectionOperator(int cardinality,int pas, Comparator<?> c){
        return new SystematicSelectionOperator(cardinality, c, pas);
    }  

    public static SystematicRandomSelectionOperator systematicRandomSelectionOperator(int cardinality, int pas){
        return new SystematicRandomSelectionOperator(cardinality,pas);
    }

    public static ManualSamplingOperator manualSamplingOperator(int cardinality){
        return new ManualSamplingOperator(cardinality);
    }

    public static <T> Operator[] parameterizedOperators( Function<T,Operator> operator, T... values  ){
        return Arrays.stream(values).map((T value) -> operator.apply(value)).toArray(Operator[]::new);
    }
    
}
