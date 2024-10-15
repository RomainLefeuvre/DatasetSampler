import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.OperatorFactory;
import static fr.inria.diverse.model.operator.OperatorFactory.*;
import static fr.inria.diverse.swh.SWHRepository.*;

void main(){
        Operator workflow =  
        OperatorFactory.filterOperator(
            commitNb.constraint(commit_nb -> (Integer)commit_nb>100)
        )
        .chain(randomSelectionOperator(2000))
        .input(new Set())
        .applyStep();

};
    






 

