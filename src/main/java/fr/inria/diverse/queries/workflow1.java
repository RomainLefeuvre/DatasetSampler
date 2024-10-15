package fr.inria.diverse.queries;

import java.sql.Date;

import fr.inria.diverse.model.Element;
import fr.inria.diverse.model.metadata.IMetadataLoader;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.clustering.ClusteringOperator;
import fr.inria.diverse.model.operator.selection.filter.FilterOperator;
import fr.inria.diverse.model.operator.selection.sampling.automatic.RandomSelectionOperator;
import fr.inria.diverse.swhMetadata.Metadata.ExternalMetadata;
import fr.inria.diverse.swhMetadata.Metadata.SWHRepoMeta;
public class workflow1 {
   
    public static void main(String[] args) {
        Operator workflow =  
        new FilterOperator(
            SWHRepoMeta.languages.constraint(lang -> lang=="Java")
            .and(SWHRepoMeta.latestCommitDate.constraint( commit_date -> (Long) commit_date > new Date(2019, 10, 10).getTime())           
            )
        )
        .addMetadata(new EducationalMetadataLoader() )
        .next(new FilterOperator( ExternalMetadata.educationalMetadata.constraint(isEducationalRepo -> (boolean)isEducationalRepo)))
        //Todo how to express the cardinality with formula on set size ?
        .next(new RandomSelectionOperator(2000))
        .next(new ClusteringOperator(
                new FilterOperator (SWHRepoMeta.contributorsNb.constraint( contributorsNb -> (Integer) contributorsNb==1)),
                new FilterOperator (SWHRepoMeta.contributorsNb.constraint( contributorsNb -> (Integer) contributorsNb >=2 && (Integer) contributorsNb <=3)),
                new FilterOperator (SWHRepoMeta.contributorsNb.constraint( contributorsNb -> (Integer) contributorsNb >=4 && (Integer) contributorsNb <=10)),
                new FilterOperator (SWHRepoMeta.contributorsNb.constraint( contributorsNb -> (Integer) contributorsNb >10))
                )
        
        )  
        ;
    } 
    
}





 class EducationalMetadataLoader  implements IMetadataLoader{

    @Override
    public void loadMetadata(Element e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadMetadata'");
    }

}

