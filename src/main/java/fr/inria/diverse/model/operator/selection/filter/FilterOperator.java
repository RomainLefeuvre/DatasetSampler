package fr.inria.diverse.model.operator.selection.filter;

import fr.inria.diverse.model.constraint.Constraint;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.selection.SelectionOperator;

public class FilterOperator extends SelectionOperator {
    Constraint<?> constraint;
   

    public FilterOperator(Constraint constraint) {
        this.constraint = constraint;
    }

    @Override
    public Operator execute() {
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }


    
}
