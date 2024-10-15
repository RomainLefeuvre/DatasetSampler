package fr.inria.diverse.queries;

import java.sql.Date;

import fr.inria.diverse.model.Element;
import fr.inria.diverse.model.metadata.IMetadataLoader;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.OperatorFactory;
import fr.inria.diverse.swhMetadata.Metadata.ExternalMetadata;
//Static import for metadata
import static fr.inria.diverse.swhMetadata.Metadata.SWHRepoMeta.*;
//Static import for operator factory
import static fr.inria.diverse.model.operator.OperatorFactory.*;
public class Workflow1 {
   
    public static void main(String[] args) {
        Operator workflow =  
        OperatorFactory.filterOperator(
            languages.constraint(lang -> lang=="Java")
            .and(latestCommitDate.constraint( commit_date -> (Long) commit_date > new Date(2019, 10, 10).getTime()))
        )
        .addMetadata(new EducationalMetadataLoader() )
        .chain(filterOperator( ExternalMetadata.educationalMetadata.constraint(isEducationalRepo -> (boolean)isEducationalRepo)))
        .chain(randomSelectionOperator(2000))
        .chain(clusteringOperator(
                 filterOperator(contributorsNb.constraint( contributorsNb -> (Integer) contributorsNb==1)),
                 filterOperator (contributorsNb.constraint( contributorsNb -> (Integer) contributorsNb >=2 && (Integer) contributorsNb <=3)),
                 filterOperator (contributorsNb.constraint( contributorsNb -> (Integer) contributorsNb >=4 && (Integer) contributorsNb <=10)),
                 filterOperator(contributorsNb.constraint( contributorsNb -> (Integer) contributorsNb >10)
                ))     
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

