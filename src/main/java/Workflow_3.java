import fr.inria.diverse.model.metadata.Metadata;
import static fr.inria.diverse.model.operator.OperatorFactory.*;
import static fr.inria.diverse.runtime.loader.LoaderFactory.*;

// CodeLL: A Lifelong Learning Dataset to Support the Co-Evolution
// of Data and Language Models of Code
// https://ieeexplore.ieee.org/abstract/document/10555636?casa_token=pZuyAa3DMDUAAAAA:69gJ33nLXd5crRJ75Pyd1uv1XcRlcD24XpfTG7AjvwHdl6G0-LUYZ4pyblX7EP3_4qcgS1ptBQ

// Workflow description in the paper :
/* 
  "From the initial dump, we exclude Debian packages due
  to the absence of .py files
  [...]
  we filter out repositories and package [...]
  (not) labeled with terms like “machine learning" and “neural network",
  In cases where artifacts do not align with any search term, we
  automatically evaluate whether they use any third-party libraries
  related to machine learning.
  [...]
  We discard
  archives with less than two releases as it does not enable any code
  evolution analysis, and end up with 71 archives composed of 26
  PyPI packages and 45 GitHub repositories

  "
 */

void main(){
//Declaration of Metadata
    Metadata<String> url = new Metadata<>("id",String.class);
    Metadata<Boolean> containsPythonFile = new Metadata<>("containsPythonFile",Boolean.class);
    Metadata<String> label = new Metadata<>("label", String.class);
    Metadata<Boolean> useThirdPartyMLLibrary = new Metadata<>("mlLib", Boolean.class);
    Metadata<Integer> releaseNb = new Metadata<>("releaseNb", Integer.class);


    filterOperator(containsPythonFile.boolConstraint(x->x)
                   .and(label.boolConstraint(x -> x.equals("machine learning")||
                                                  x.equals("neural network"))
                        .or(useThirdPartyMLLibrary.boolConstraint(x->x)))
                   .and(releaseNb.boolConstraint(x -> x>2))
                  )              
    .input(jsonLoader("input.json",url))
    .execute();
}
    





 

