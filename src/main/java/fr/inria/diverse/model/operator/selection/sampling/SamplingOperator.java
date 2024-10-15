package fr.inria.diverse.model.operator.selection.sampling;

import fr.inria.diverse.model.operator.selection.SelectionOperator;

public abstract class SamplingOperator extends SelectionOperator {
    protected int cardinality;

    public SamplingOperator(int cardinality) {
        this.cardinality = cardinality;
    }
    
}
