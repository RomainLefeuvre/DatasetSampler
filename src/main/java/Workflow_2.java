import fr.inria.diverse.model.metadata.Metadata;

import static fr.inria.diverse.model.element.loader.LoaderFactory.*;
import static fr.inria.diverse.model.element.writter.WritterFactory.*;
import static fr.inria.diverse.model.operator.OperatorFactory.*;

// Insights into Female Contributions in Open-Source Projects
// DOI : 10.1109/MSR59073.2023.00055

// Workflow description in the paper :
/* 
  for each of the 17 programming languages that WoC identifies, we select the
  most popular (based on star-rating on GitHub) project (written
  primarily in that language), which is available in both GitHub
  and WoC. These 17 popular projects constitute our initial
  dataset to address research questions RQ1 and RQ2"
 */

void main(){
//Declaration of Metadata
    var url = Metadata.ofString("id");
    var stars = Metadata.ofInteger("stars");
    var language = Metadata.ofString("language");

    //Workflow Declaration and Execution
    partitionOperator(              
        parameterizedOperators(
            //Operator that will be applied for each subset of the partition
            lang->filterOperator(language.boolConstraint(x-> x.equals(lang)))
                  //Chain a systematic operator, sort by stars  
                  //and select the most starred repo by subset
                  .chain(systematicSelectionOperator(1,1,
                            stars.boolComparator((stars1,stars2)->stars1<stars2?stars1:stars2))),
                                     //Value that will be used for partionning              
    "Ruby","JavaScript","PHP","C++","C","Go","Java","Python","C#",
        "Lua","Swift","Scala","R","Rust","Lisp","SQL","Fortran" ))
    .input(jsonLoader("input.json",url))
    .execute();;
}
    





 

