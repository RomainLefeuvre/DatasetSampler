package fr.inria.diverse.model.operator.selection.sampling.automatic;

public class SystematicRandomSelectionOperator extends AutomaticSamplingOperator {
    public SystematicRandomSelectionOperator(int cardinality, int pas) {
        super(cardinality);
        this.pas=pas;
    }

    int pas;
}
