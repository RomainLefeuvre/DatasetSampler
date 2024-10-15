package fr.inria.diverse.model.operator.selection.filter;

import fr.inria.diverse.model.Constraint;
import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.selection.SelectionOperator;

public class FilterOperator extends SelectionOperator {
    Constraint[] constraints;
    Set in;
    Set out;

    public FilterOperator(Constraint... constraints) {
        this.in = in;
        this.constraints = constraints;
    }

    @Override
    public Operator applyStep() {
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }


    
}
