package fr.inria.diverse.model.metadata;

public class MetadataValue {
    Metadata metadata;
    private Object value;
    //ToDo add safe type management and checks

    

    public  Object getValue(){
        return value;
    }



    public MetadataValue(Metadata metadata, Object value) {
        this.metadata = metadata;
        this.value = value;
    }

    public MetadataValue(Metadata metadata){
        this.metadata = metadata;
    }
}
