import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.OperatorFactory;
import static fr.inria.diverse.model.operator.OperatorFactory.*;
import static fr.inria.diverse.runtime.loader.LoaderFactory.*;
void main()  {
    //Declaration of Metadata
    Metadata<String> id = new Metadata<>("id",String.class);
    Metadata<Integer> commitNb = new Metadata<>("commitNb",Double.class);

    //Workflow Declaration and Execution
    Operator workflow = OperatorFactory.filterOperator(commitNb.boolConstraint(x -> x>100))
                                       .chain(randomSelectionOperator(10))
                                       .input(jsonLoader("/home/rlefeuvr/Documents/Workspace/SAMPLING/prototype/sampling/src/main/resources/input.json",id,commitNb))
                                       .execute();

};
    





 

