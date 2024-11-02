package fr.inria.diverse.swh.MetadataValue;

import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.metadata.MetadataValue;

public class SWHMetadataValue extends MetadataValue{
    public SWHMetadataValue(Metadata metadata) {
        super(metadata);
    }

    Long internalId;

    @Override
    public Object getValue() {
        throw(new RuntimeException("unimplemented"));
    }
}
