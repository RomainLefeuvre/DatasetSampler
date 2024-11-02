package fr.inria.diverse.model.metadata;

public class MetadataValue<T> {
    Metadata<T> metadata;
    private Object value;
    //ToDo add safe type management and checks

    

    public  Object getValue(){
        return value;
    }

    public MetadataValue(Metadata<T> metadata, T value) {
        this.metadata = metadata;
        this.value = value;
    }

    public MetadataValue(Metadata<T> metadata){
        this.metadata = metadata;
    }
}
