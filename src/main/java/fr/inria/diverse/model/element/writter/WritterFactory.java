package fr.inria.diverse.model.element.writter;

import java.nio.file.Paths;

public class WritterFactory {
    public static JsonWritter jsonWritter(String path){
        return new JsonWritter(Paths.get(path));
    }

}
