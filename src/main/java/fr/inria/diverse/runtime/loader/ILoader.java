package fr.inria.diverse.runtime.loader;

import java.util.List;

import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.metadata.Metadata;;


public interface ILoader {
   Set loadSet();
   List<Metadata> loadMetadata();
}
