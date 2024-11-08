package fr.inria.diverse.runtime;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import fr.inria.diverse.model.constraint.BoolConstraint;
import fr.inria.diverse.model.constraint.Constraint;
import fr.inria.diverse.model.element.Set;
import fr.inria.diverse.model.metadata.*;
public class Store {
    private static Store INSTANCE;

    Map<String,Metadata> map = new HashMap<>();
    Map<String,Set> set = new HashMap<>();
    private  Store() {        
    }
    
    public static Store getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Store();
        }
        
        return INSTANCE;
    }

    public static BoolConstraint boolConstraint(Function<Object, Boolean> constraint, String targetedMetadataName){
        Metadata targetedMetadata = INSTANCE.map.get(targetedMetadataName);
        return new BoolConstraint(constraint, targetedMetadata);
    }

}
