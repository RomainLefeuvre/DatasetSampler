package fr.inria.diverse.swh;

import java.util.List;

import fr.inria.diverse.model.element.Repository;
import fr.inria.diverse.model.metadata.Metadata;

public class SWHRepository extends Repository {
    public static Metadata<String> id = new Metadata<>("id",String.class);
    public static Metadata<String> swhid = new Metadata<>("swhid",String.class);
    public static Metadata<List<String>> languages = new Metadata<>("languages",List.class);
    public static Metadata<Integer> contributorsNb = new Metadata<>("contributorsNb",String.class);
    public static Metadata<Long> latestCommitDate = new Metadata<>("latestCommitDate",Long.class);
    public static Metadata<Integer> commitNb = new Metadata<>("commitNb",Integer.class);

    public SWHRepository(Metadata<String> id) {
        super(id);
    }
    public SWHRepository(){
        super(id);
    }
}
