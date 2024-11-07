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
            languages.boolConstraint(lang -> lang.contains("Java"))
            .and(latestCommitDate.boolConstraint( commitDate -> commitDate > new Date(2019, 10, 10).getTime()))
        )
        .addMetadata(new EducationalMetadataLoader() )
        .chain(filterOperator(educationalMetadata.boolConstraint(isEducationalRepo -> (boolean)isEducationalRepo)))
        .chain(randomSelectionOperator(2000))
        .chain(partitionOperator(
                 filterOperator(contributorsNb.boolConstraint( contributorsNb -> contributorsNb==1)),
                 filterOperator(contributorsNb.boolConstraint( contributorsNb -> contributorsNb >=2 && contributorsNb <=3)),
                 filterOperator(contributorsNb.boolConstraint( contributorsNb -> contributorsNb >=4 && contributorsNb <=10)),
                 filterOperator(contributorsNb.boolConstraint( contributorsNb -> contributorsNb >10)
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

