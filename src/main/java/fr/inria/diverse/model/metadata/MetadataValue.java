package fr.inria.diverse.model.metadata;

public class MetadataValue<T> {
    Metadata<T> metadata;
    private T value;
    //ToDo add safe type management and checks

    

    public  T getValue(){
        return value;
    }

    public Metadata<T> getMetadata(){
        return metadata;
    }

    public MetadataValue(Metadata<T> metadata, T value) {
        this.metadata = metadata;
        this.value = value;
    }

    public MetadataValue(Metadata<T> metadata){
        this.metadata = metadata;
    }
}
