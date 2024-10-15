package fr.inria.diverse.queries;

import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.OperatorFactory;
import fr.inria.diverse.model.operator.selection.filter.FilterOperator;
import static fr.inria.diverse.swhMetadata.Metadata.SWHRepoMeta.*;
import static fr.inria.diverse.model.operator.OperatorFactory.*;

public class Workflow2 {
   
    public static void main(String[] args) {
        Operator workflow =  
        OperatorFactory.filterOperator(
            commitNb.constraint(commit_nb -> (Integer)commit_nb>100)
        )
        .chain(randomSelectionOperator(2000))
        .input(new Set())
        .applyStep();

    } 
    
}





 

