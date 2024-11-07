package fr.inria.diverse.swh.MetadataValue;

import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.metadata.MetadataValue;

public class SWHMetadataValue<T> extends MetadataValue<T>{
    public SWHMetadataValue(Metadata<T> metadata) {
        super(metadata);
    }

    Long internalId;

    @Override
    public T getValue() {
        throw(new RuntimeException("unimplemented"));
    }
}
