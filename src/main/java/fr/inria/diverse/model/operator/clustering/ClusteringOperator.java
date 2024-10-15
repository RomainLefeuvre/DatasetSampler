package fr.inria.diverse.model.operator.clustering;

import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.selection.SelectionOperator;

public  class ClusteringOperator extends Operator {
    SelectionOperator[] selectionOperators;

    public ClusteringOperator(SelectionOperator... selectionOperators) {
        this.selectionOperators = selectionOperators;
    }
    

}
