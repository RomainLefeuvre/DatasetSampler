package fr.inria.diverse.model.operator.selection.sampling.automatic;

import fr.inria.diverse.model.constraint.Comparator;

public class SystematicSelectionOperator extends AutomaticSamplingOperator {
    Comparator<?> orderConstraint;

    public SystematicSelectionOperator(int cardinality, Comparator orderConstraint, Integer pas) {
        super(cardinality);
        this.orderConstraint=orderConstraint;
    }
}
