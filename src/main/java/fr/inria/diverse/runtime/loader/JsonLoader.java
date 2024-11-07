package fr.inria.diverse.runtime.loader;

import static fr.inria.diverse.swh.SWHRepository.id;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fr.inria.diverse.model.Repository;
import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.metadata.MetadataValue;

public class JsonLoader extends Loader{
    public JsonLoader(Path setPath,Metadata<?> ...metadatas){
        super(metadatas);
        this.setPath = setPath;
    }

    private Path setPath;
    private Set set;
    private Gson gson = new Gson();
    


    @Override
    public Set loadSet() {
        try (FileReader reader = new FileReader(setPath.toString())) {
             // Define the type of the data as a list of maps
            Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
            // Parse JSON array to List<Map<String, Object>>
            List<Map<String, Object>> jsonList = gson.fromJson(reader, listType);
            this.set = new Set();
            for (Map<String,Object> json : jsonList){
                Repository repository = createRepositoryFromMap(json);
               this.set.addElement(repository);
            }
            return set;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    


    private Repository createRepositoryFromMap(Map<String, Object> jsonObject){
        Repository repo = new Repository(this.metadatas.get("id")); 
        List<MetadataValue<?>> metadataValues = new ArrayList<MetadataValue<?>>();
        for(Metadata<?> metadata : metadatas.values()){
            metadataValues.add(metadata.createMetadataValue(metadata.type.cast(jsonObject.get(metadata.name))));
        }
        repo.addMetadataValues(metadataValues);
        return repo;
    }
    


   

    

    
    

    
}
