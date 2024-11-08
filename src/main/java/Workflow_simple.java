import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.operator.*;

import static fr.inria.diverse.model.element.loader.LoaderFactory.*;
import static fr.inria.diverse.model.element.writter.WritterFactory.*;

import static fr.inria.diverse.model.operator.OperatorFactory.*;

void main(){
    var inputPath = getClass().getClassLoader().getResource("input.json").getPath();

    var id = Metadata.ofString("id");
    var commitNb = Metadata.ofDouble("commitNb");

    //Workflow Declaration and Execution
    Operator op = filterOperator(commitNb.boolConstraint(x -> x>100))
    .chain(randomSelectionOperator(10))
    .input(jsonLoader(inputPath,id,commitNb))
    .output(jsonWritter("out.json"))
    .execute();

    System.out.println(op);
};
    



