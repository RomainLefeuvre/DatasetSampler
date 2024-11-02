import java.sql.Date;
import fr.inria.diverse.model.Element;
import fr.inria.diverse.model.metadata.IMetadataLoader;
import fr.inria.diverse.model.operator.Operator;
import fr.inria.diverse.model.operator.OperatorFactory;
//Static import for operator factory
import static fr.inria.diverse.model.operator.OperatorFactory.*;
import static fr.inria.diverse.queries.Metadata.ExternalMetadata.*;
import static fr.inria.diverse.swh.SWHRepository.*;
void main() {
        Operator workflow =  
        OperatorFactory.filterOperator(
            languages.boolConstraint(lang -> lang=="Java")
            .and(latestCommitDate.boolConstraint( commit_date -> (Long) commit_date > new Date(2019, 10, 10).getTime()))
        )
        .addMetadata(new EducationalMetadataLoader() )
        .chain(filterOperator(educationalMetadata.boolConstraint(isEducationalRepo -> (boolean)isEducationalRepo)))
        .chain(randomSelectionOperator(2000))
        .chain(clusteringOperator(
                 filterOperator(contributorsNb.boolConstraint( contributorsNb -> (Integer) contributorsNb==1)),
                 filterOperator (contributorsNb.boolConstraint( contributorsNb -> (Integer) contributorsNb >=2 && (Integer) contributorsNb <=3)),
                 filterOperator (contributorsNb.boolConstraint( contributorsNb -> (Integer) contributorsNb >=4 && (Integer) contributorsNb <=10)),
                 filterOperator(contributorsNb.boolConstraint( contributorsNb -> (Integer) contributorsNb >10)
                ))     
        )  
        ;
    } 
    






 class EducationalMetadataLoader  implements IMetadataLoader{

    @Override
    public void loadMetadata(Element e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadMetadata'");
    }

}

