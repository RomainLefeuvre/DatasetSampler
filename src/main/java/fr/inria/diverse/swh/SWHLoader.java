package fr.inria.diverse.swh;

import fr.inria.diverse.Graph;
import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.runtime.loader.Loader;

import static fr.inria.diverse.swh.MetadataValue.SWHMetadataValue.*;
import static fr.inria.diverse.swh.SWHRepository.id;

import java.nio.file.Path;
import java.nio.file.Paths;
public class SWHLoader extends Loader{
    Graph g = new Graph();
    Path graphPath;
    SWHLoader(Path graphPath){
      super(id);
      this.graphPath = graphPath;
   }
    @Override
    public Set loadSet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadSet'");
    }
    

    public static SWHLoader swhLoader(String path){
    
        return new SWHLoader(Paths.get(path));
    }
    
}
