package fr.inria.diverse.model.element.writter;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import fr.inria.diverse.model.element.Element;
import fr.inria.diverse.model.element.Repository;
import fr.inria.diverse.model.element.Set;
import fr.inria.diverse.model.element.Writter;
import fr.inria.diverse.model.metadata.Metadata;
import fr.inria.diverse.model.metadata.MetadataValue;
import com.google.gson.*;

public class JsonWritter extends Writter {
    Path setPath;
    public JsonWritter(Path setPath){
        this.setPath=setPath;
    }

    @Override
    public void writeSet(Set set) {
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(Element.class, new ElementJsonSerializer())
            .setPrettyPrinting()
            .create();

       String jsonOutput = gson.toJson(set);
       // Save JSON output to file
        try (FileWriter writer = new FileWriter(setPath.toString())) {
            writer.write(jsonOutput);
            System.out.println("JSON has been written to "+setPath);
        } catch (IOException e) {
            new RuntimeException("Error while saving file",e);
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
                //Todo handle Set metadata too
                JsonArray elementsArray = new JsonArray();
                Set set = (Set) element;
                for (Element childElement : set.getElements()) {
                    elementsArray.add(serialize(childElement, childElement.getClass(), context));
                }
            }
            return jsonObject;
        }

        
    }
    
}
