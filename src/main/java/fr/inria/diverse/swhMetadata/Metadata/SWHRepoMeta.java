package fr.inria.diverse.swhMetadata.Metadata;

import java.util.List;

import fr.inria.diverse.model.metadata.Metadata;

public class SWHRepoMeta {
    public static Metadata swhid = new Metadata("swhid",String.class);
    public static Metadata languages = new Metadata("languages",List.class);
    public static Metadata contributorsNb = new Metadata("contributorsNb",String.class);
    public static Metadata latestCommitDate = new Metadata("latestCommitDate",Long.class);
    public static Metadata commitNb = new Metadata("commitNb",Integer.class);

    
}
