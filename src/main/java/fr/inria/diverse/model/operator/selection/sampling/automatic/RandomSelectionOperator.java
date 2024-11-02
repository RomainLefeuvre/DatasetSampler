package fr.inria.diverse.model.operator.selection.sampling.automatic;

import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.operator.Operator;

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

    @Override
    public Operator execute() {
        this.output = this.input.getRandomSubset(this.cardinality);
        super.execute();
        return this;
    }

   


    

 
    
}
