package fr.inria.diverse.model.operator.selection.sampling.manual;

import fr.inria.diverse.model.element.Set;
import fr.inria.diverse.model.metadata.MetadataValue;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.selection.sampling.SamplingOperator;

public class ManualSamplingOperator<T> extends SamplingOperator{

    public ManualSamplingOperator(T... id) {
        super(id.length);
    }

    @Override
    public Operator execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }
    
}
