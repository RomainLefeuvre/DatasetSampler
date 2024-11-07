package fr.inria.diverse.model.operator.selection.filter;

import fr.inria.diverse.model.constraint.Constraint;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.selection.SelectionOperator;

public class FilterOperator extends SelectionOperator {
    Constraint<?>[] constraints;
   

    public FilterOperator(Constraint<?>... constraints) {
        this.constraints = constraints;
    }

    @Override
    public Operator execute() {
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }


    
}
