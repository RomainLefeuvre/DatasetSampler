import fr.inria.diverse.model.metadata.Metadata;
import static fr.inria.diverse.model.operator.OperatorFactory.*;
import static fr.inria.diverse.runtime.loader.LoaderFactory.*;

// An Empirical Study to Investigate Collaboration
//Among Developers in Open Source Software (OSS)
//  doi: 10.1109/MSR59073.2023.00054

// Workflow description in the paper :
/* 
  "
we find all projects that have more than a single author and
are available on Github leveraging the World of Code (WoC)
dataset [5]. Then we randomly sample 20, 000 projects from
that subset
  "
 */

void main(){
//Declaration of Metadata

    var url = new Metadata<String>("id",String.class);
    var authorNb = new Metadata<Integer>("authorNb", Integer.class);
    var containsPythonFileModifiedByMultipleAuthors = 
                              new Metadata<Boolean>("containsPythonFileMultiAuthors",Boolean.class);
    var availableOnGithub = new Metadata<Boolean>("availableOnGithub",Boolean.class);
 
    filterOperator(authorNb.boolConstraint(x->x>1)
                   .and(availableOnGithub.boolConstraint(x->x)))
    .chain(randomSelectionOperator(20000))
    .chain(filterOperator(containsPythonFileModifiedByMultipleAuthors.boolConstraint(x->x)))  
    .input(jsonLoader("input.json",url))
    .execute();

}
    





 

