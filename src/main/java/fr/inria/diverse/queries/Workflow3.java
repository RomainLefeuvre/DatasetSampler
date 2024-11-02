import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.operator.Operator;

import static fr.inria.diverse.model.operator.OperatorFactory.*;
import static fr.inria.diverse.runtime.Store.*;

void main(){
        filterOperator(
            boolConstraint(commit_nb -> (Integer)commit_nb>100,"commitNb")
        )
        .chain(randomSelectionOperator(2000))
        .input(new Set())
        .execute();

};
    






 

