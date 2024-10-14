package fr.inria.diverse.model.operator;

import fr.inria.diverse.model.Set;

public abstract class Operator {
    Set input;
    Set output;
    Operator nextOperator;
}
