import fr.inria.diverse.model.element.Set;
import fr.inria.diverse.model.operator.Operator;

import static fr.inria.diverse.model.operator.OperatorFactory.*;
import static fr.inria.diverse.runtime.Store.*;
import static fr.inria.diverse.swh.SWHRepository.*;

void main(){
        filterOperator(
            commitNb.boolConstraint(commit_Nb -> commit_Nb>100)
        )
        .chain(randomSelectionOperator(2000))
        .input(new Set())
        .execute();

};
    






 

