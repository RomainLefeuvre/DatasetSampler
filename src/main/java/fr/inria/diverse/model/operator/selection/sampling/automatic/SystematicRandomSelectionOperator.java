package fr.inria.diverse.model.operator.selection.sampling.automatic;
import fr.inria.diverse.model.operator.Operator;

public class SystematicRandomSelectionOperator extends AutomaticSamplingOperator {
    public SystematicRandomSelectionOperator(int cardinality, int pas) {
        super(cardinality);
        this.pas=pas;
    }

    int pas;

    @Override
    public Operator applyStep() {
        //Todo
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
        
    }
}
