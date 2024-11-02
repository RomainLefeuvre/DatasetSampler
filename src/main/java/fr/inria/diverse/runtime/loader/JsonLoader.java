package fr.inria.diverse.runtime.loader;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fr.inria.diverse.model.Repository;
import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.metadata.Metadata;

public class JsonLoader implements ILoader{
    public JsonLoader(Path metadataPath, Path setPath){
        this.metadataPath= metadataPath;
        this.setPath = setPath;
    }

    private Path metadataPath;
    private Path setPath;
    private Set set;
    private List<Metadata> metadatas;
    private Gson gson = new Gson();
    private Type metadataListType = new TypeToken<List<Metadata>>(){}.getType();
    
    @Override
    public Set loadSet() {
        Type listRepos = new TypeToken<List<Repository>>(){}.getType();

        try (FileReader reader = new FileReader(setPath.toString())) {
            List<Repository> repos = gson.fromJson(reader, listRepos);
            Set result = new Set();
            return set;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    


    @Override
    public List<Metadata> loadMetadata() {
        return this.metadatas;
    }

    

    
    

    
}