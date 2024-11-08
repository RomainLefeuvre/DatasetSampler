package fr.inria.diverse.model.constraint;

import java.util.function.BiFunction;
import java.util.function.Function;

import fr.inria.diverse.model.element.Element;
import fr.inria.diverse.model.metadata.Metadata;

public class BoolComparator<T> extends Comparator<T> {
    public BoolComparator(Metadata<T> targetedMetadata) {
        super(targetedMetadata);
        //TODO Auto-generated constructor stub
    }

    public BoolComparator( Metadata<T> targetedMetadata,BiFunction<T,T, T> comparator) {
        super(targetedMetadata);
        this.comparator = comparator;
        //Todo add check
        this.targetedMetadata = targetedMetadata;
    }

    BiFunction<T,T, T> comparator;

    @Override
    public Element compare(Element a, Element b) {
        T aValue = a.getMetadataValue(this.targetedMetadata).getValue();
        T bValue = b.getMetadataValue(this.targetedMetadata).getValue();
        T result = comparator.apply(aValue,bValue);

        return result.equals(aValue)?a:b;
    }

    

    }
    

    


