import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.OperatorFactory;
import static fr.inria.diverse.model.operator.OperatorFactory.*;
import static fr.inria.diverse.runtime.loader.LoaderFactory.*;


//Declaration of Metadata
public static Metadata<String> id = new Metadata<>("id",String.class);
public static Metadata<String> url = new Metadata<>("url",String.class);
public static Metadata<String> language = new Metadata<>("language",String.class);
public static Metadata<Integer> commitNb = new Metadata<>("commitNb",Integer.class);

void main()  {
         Operator workflow =  
        OperatorFactory.filterOperator(
            commitNb.boolConstraint(commit_nb -> commit_nb>100)
        )
        .chain(randomSelectionOperator(2000))
        .input(jsonLoader("/home/rlefeuvr/Documents/Workspace/SAMPLING/prototype/sampling/src/main/resources/input.json",
                            id,url,language,commitNb))
        .execute();

};
    






 

