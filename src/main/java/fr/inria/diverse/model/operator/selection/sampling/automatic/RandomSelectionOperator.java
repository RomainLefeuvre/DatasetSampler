package fr.inria.diverse.model.operator.selection.sampling.automatic;

public class RandomSelectionOperator extends AutomaticSamplingOperator {
    int seed;

    public RandomSelectionOperator(int seed, int cardinality) {
        super(cardinality);
        this.seed = seed;
    }

    public RandomSelectionOperator( int cardinality) {
        super(cardinality);
        this.seed = 0;
    }
    
}
