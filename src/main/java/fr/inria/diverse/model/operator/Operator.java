package fr.inria.diverse.model.operator;

import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.metadata.IMetadataLoader;

public abstract class Operator {
    Set input;
    Set output;
    private Operator nextOperator;

    public Operator addMetadata(IMetadataLoader loader){
        loader.loadMetadata(output);
        return this;
    }

    public Operator next(Operator o){
        this.nextOperator=o;
        return o;
    }
}
