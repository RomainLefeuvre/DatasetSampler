package fr.inria.diverse.model.operator;

import fr.inria.diverse.model.constraint.Constraint;
import fr.inria.diverse.model.element.Loader;
import fr.inria.diverse.model.element.Set;
import fr.inria.diverse.model.element.Writter;
import fr.inria.diverse.model.metadata.IMetadataLoader;
import fr.inria.diverse.model.operator.clustering.PartitionOperator;
import fr.inria.diverse.model.operator.selection.SelectionOperator;
import fr.inria.diverse.model.operator.selection.filter.FilterOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.RandomSelectionOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.SystematicRandomSelectionOperator;
import fr.inria.diverse.model.operator.selection.sampling.manual.ManualSamplingOperator;

public abstract class Operator {
    protected Set input;
    protected Set output;
    protected Writter outputWritter;
    protected Operator nextOperator;
    protected Operator previousOperator;
    

    public Operator addMetadata(IMetadataLoader loader){
        loader.loadMetadata(output);
        return this;
    }

      public Operator execute(){
        if(nextOperator != null){
            nextOperator.input=this.output;
            nextOperator.execute();
        }else if (outputWritter!=null){
            outputWritter.writeSet(this.input);
        }
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
        this.getWorkflowRootOperator().execute();
        return this;
    }

   // public evaluate()

    public Set output(){
        return this.output;
    }

    public Operator output(Writter writter){
        this.outputWritter =writter;
        return this;
    }


    public Operator input(Set input){
        this.input=input;
        return this;
    }

    public Operator input(Loader loader){

        this.input=loader.loadSet();
        return this;
    }

    public Operator chain(Operator operator){
        this.nextOperator=operator;
        this.previousOperator = operator;
        return operator;
    }


   





        
    
}
