package fr.inria.diverse.model.element;

import java.util.HashMap;

import fr.inria.diverse.model.metadata.Metadata;;


public abstract class Loader {
   protected HashMap<String,Metadata<?>> metadatas = new HashMap<>();

   public Loader(Metadata<?> ...metadatas){
      for(Metadata<?> metadata : metadatas){
         this.metadatas.put(metadata.name, metadata);
     }
   }
   public abstract Set loadSet();
}
