package fr.inria.diverse.runtime.writter;

import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import fr.inria.diverse.model.Element;
import fr.inria.diverse.model.Repository;
import fr.inria.diverse.model.Set;
import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.metadata.MetadataValue;

public class JsonWritter extends Writter {
    Path setPath;
    public JsonWritter(Path setPath){
        this.setPath=setPath;
    }

    @Override
    public void writeSet(Set set) {
       for(Element element : set.getElements()){
        List<?> result = new ArrayList<>();

            if(element instanceof Element){
                //todo
            }
       }
    }

    private class ElementJsonSerializer implements JsonSerializer<Element> {
        @Override
        public JsonElement serialize(Element element, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject jsonObject = new JsonObject();
            if (element instanceof Repository){
                Repository repository = (Repository) element;
                for (Entry<Metadata<?>, MetadataValue> e : repository.getMetadataValue().entrySet()){
                    jsonObject.addProperty(e.getKey().name, e.getValue().getValue().toString());
                }
            }else if (element instanceof Set){
                Set set = new Set();
            }

/*
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("groupName", group.getGroupName());
    
            // Create a JSON array to hold the users
            JsonElement usersArray = context.serialize(group.getUsers());
            jsonObject.add("users", usersArray);
    */
            return jsonObject;
        }

        
    }
    
}
