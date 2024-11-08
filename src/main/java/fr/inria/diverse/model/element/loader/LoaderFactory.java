package fr.inria.diverse.model.element.loader;

import java.nio.file.Paths;

import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.swh.SWHLoader;

public class LoaderFactory {
    public static JsonLoader jsonLoader(String setPath, Metadata<?>... metadatas){
        return new JsonLoader(Paths.get(setPath),metadatas);
    }

}
