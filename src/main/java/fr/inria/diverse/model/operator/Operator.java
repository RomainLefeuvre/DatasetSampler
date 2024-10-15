package fr.inria.diverse.model.operator;

import fr.inria.diverse.model.Constraint;
import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.metadata.IMetadataLoader;
import fr.inria.diverse.model.operator.clustering.ClusteringOperator;
import fr.inria.diverse.model.operator.selection.SelectionOperator;
import fr.inria.diverse.model.operator.selection.filter.FilterOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.RandomSelectionOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.SystematicRandomSelectionOperator;
import fr.inria.diverse.model.operator.selection.sampling.manual.ManualSamplingOperator;

public abstract class Operator {
    protected Set input;
    protected Set output;
    protected Operator nextOperator;
    protected Operator previousOperator;


    public Operator addMetadata(IMetadataLoader loader){
        loader.loadMetadata(output);
        return this;
    }

      public Operator applyStep(){

        nextOperator.input=this.output;
        nextOperator.applyStep();
        return this;
    }

    public Operator getWorkflowRootOperator(){
        if(this.previousOperator==null){
            return this;
        }else{
            return this.previousOperator.getWorkflowRootOperator();
        }
    }

    public Operator executeWorkflow(Set input){
        this.getWorkflowRootOperator().applyStep();
        return this;
    }

   // public evaluate()

    public Set output(){
        return this.output;
    }

    public Operator input(Set input){
        this.input=input;
        return this;
    }

    public Operator chain(Operator operator){
        this.nextOperator=operator;
        this.previousOperator = operator;
        return operator;
    }


   





        
    
}
