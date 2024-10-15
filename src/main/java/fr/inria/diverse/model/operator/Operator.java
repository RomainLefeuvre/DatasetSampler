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

    public Operator executeWorkflow(Set input){
     
    }

    public getRootOperator()

   // public evaluate()

    public Set output(){
        return this.output;
    }

    public Operator input(Set input){
        this.input=input;
        return this;
    }


    //List all possible concrete operator that could be chained

    public Operator chainFilterOperator(Constraint... constraints){
        this.nextOperator = new FilterOperator(constraints);
        return nextOperator;
    }

    public Operator chainClusteringOperator(SelectionOperator... selectionOperators){
        this.nextOperator = new ClusteringOperator(selectionOperators);
        return nextOperator;
    }

    public Operator chainRandomSelectionOperator(int seed, int cardinality){
        this.nextOperator = new RandomSelectionOperator(seed, cardinality);
        return nextOperator;
    }

    public Operator chainRandomSelectionOperator( int cardinality){
        this.nextOperator = new RandomSelectionOperator(cardinality);
        return nextOperator;
    }

    public Operator chainSystematicRandomSelectionOperator(int cardinality, int pas){
        this.nextOperator = new SystematicRandomSelectionOperator(cardinality,pas);
        return nextOperator;
    }

    public Operator chainManualSamplingOperator(int cardinality){
        this.nextOperator = new ManualSamplingOperator(cardinality);
        return nextOperator;
    }





        
    
}
