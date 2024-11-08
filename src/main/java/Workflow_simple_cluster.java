import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.OperatorFactory;

import static fr.inria.diverse.model.element.loader.LoaderFactory.*;
import static fr.inria.diverse.model.element.writter.WritterFactory.*;
import static fr.inria.diverse.model.operator.OperatorFactory.*;
void main()  {
 var id = Metadata.ofString("id");
 var commitNb = Metadata.ofDouble("commitNb");

 //Cluster Operator
 partitionOperator(
   filterOperator(commitNb
        .boolConstraint(x -> x<100)),
   filterOperator(commitNb
        .boolConstraint(x -> x<1000)),
   filterOperator(commitNb
        .boolConstraint(x -> x<10000)))
   .chain(randomSelectionOperator(2))
   .input(jsonLoader("input.json",id,commitNb))
   .execute();

  //Stratified Operator
  partitionOperator(
   filterOperator(commitNb
                  .boolConstraint(x -> x<100))
   .chain(randomSelectionOperator(100)),
   filterOperator(commitNb
                  .boolConstraint(x -> x<1000))
   .chain(randomSelectionOperator(100)),
   filterOperator(commitNb
                  .boolConstraint(x -> x<10000))
   .chain(randomSelectionOperator(100)))
   .input(jsonLoader("input.json",id,commitNb))
   .execute();

  //Quota Operator 
  partitionOperator(
   filterOperator(commitNb
                 .boolConstraint(x -> x<100))
   .chain(manualSamplingOperator(1,10,54,76,38)),
   filterOperator(commitNb
                 .boolConstraint(x -> x<1000))
   .chain(manualSamplingOperator(6,8,14)),
   filterOperator(commitNb
                 .boolConstraint(x -> x<10000))
   .chain(manualSamplingOperator(53,54,2,5)))
  .input(jsonLoader("input.json",id,commitNb))
  .execute();
};
    




 

