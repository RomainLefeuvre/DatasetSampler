package fr.inria.diverse.model.metadata;

import java.util.function.BiFunction;
import java.util.function.Function;

import fr.inria.diverse.model.constraint.BoolComparator;
import fr.inria.diverse.model.constraint.BoolConstraint;
import fr.inria.diverse.model.constraint.Constraint;

public class Metadata<T> {
    public String name;
    public Class type;
    
    

    public Metadata(String name, Class t) {
        this.name = name;
        this.type = t;
    }

    private boolean isOfType(Object obj) {
        return type.isInstance(obj);
    }

    public BoolConstraint<T> boolConstraint(Function<T, Boolean> constraint){
        return new BoolConstraint<T>(constraint, this);    }
    
    public BoolComparator<T> boolComparator(BiFunction<T,T,T> comparator){
        return new BoolComparator<>(this ,comparator);
    };

    public MetadataValue<T> createMetadataValue(Object value){
        if (!type.isInstance(value)) {
            throw new ClassCastException("Value " + value + " is not of type " + type.getName());
        }
        return new MetadataValue<>(this,(T) value);

    }

    
     // General static factory method
    public static <T> Metadata<T> of(String name, Class<T> type) {
        return new Metadata<>(name, type);
    }

    public static Metadata<String> ofString(String name) {
        return new Metadata<>(name, String.class);
    }

    public static Metadata<Integer> ofInteger(String name) {
        return new Metadata<>(name, Integer.class);
    }

    public static Metadata<Boolean> ofBoolean(String name) {
        return new Metadata<>(name, Boolean.class);
    }

    public static Metadata<Double> ofDouble(String name) {
        return new Metadata<>(name, Double.class);
    }

    public static Metadata<Float> ofFloat(String name) {
        return new Metadata<>(name, Float.class);
    }

    public static Metadata<Long> ofLong(String name) {
        return new Metadata<>(name, Long.class);
    }

    public static Metadata<Character> ofCharacter(String name) {
        return new Metadata<>(name, Character.class);
    }

    public static Metadata<Byte> ofByte(String name) {
        return new Metadata<>(name, Byte.class);
    }

    public static Metadata<Short> ofShort(String name) {
        return new Metadata<>(name, Short.class);
    }
    
}
