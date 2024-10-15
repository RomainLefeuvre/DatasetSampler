package fr.inria.diverse.model.metadata;

public class MetadataValue {
    Metadata metadata;
    private Object value;
    //ToDo add safe type management and checks
    public  <T> T getValue(){
        return (T) value;
    }
}
