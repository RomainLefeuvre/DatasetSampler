package fr.inria.diverse.swh;

import java.util.List;

import fr.inria.diverse.model.Repository;
import fr.inria.diverse.model.metadata.Metadata;

public class SWHRepository extends Repository {
    public static Metadata id = new Metadata("id",String.class);
    public static Metadata swhid = new Metadata("swhid",String.class);
    public static Metadata languages = new Metadata("languages",List.class);
    public static Metadata contributorsNb = new Metadata("contributorsNb",String.class);
    public static Metadata latestCommitDate = new Metadata("latestCommitDate",Long.class);
    public static Metadata commitNb = new Metadata("commitNb",Integer.class);

    public SWHRepository(Metadata id) {
        super(id);
        //TODO Auto-generated constructor stub
    }
    public SWHRepository(){
        super(id);
    }
}
