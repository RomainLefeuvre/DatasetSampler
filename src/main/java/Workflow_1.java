import fr.inria.diverse.model.Element;
import fr.inria.diverse.model.Repository;
import fr.inria.diverse.model.metadata.IMetadataLoader;
import fr.inria.diverse.model.metadata.Metadata;
import static fr.inria.diverse.model.operator.OperatorFactory.*;
import static fr.inria.diverse.runtime.loader.LoaderFactory.*;
import java.util.Map;
// Evolution of the Practice of Software Testing in Java Projects
// DOI : 10.1109/MSR59073.2023.00057

// Workflow description in the paper :
/*
 For evaluation, we collected the names of the Java projects
 with at least one commit in a year for all the years starting
 from 2012 to 2021 using the c2P mapping of WoC.[...]
 In this way, we created different
 samples of projects from 2012 to 2021. Finally, we randomly
 selected 20,000 projects per year from the set of projects.
 Then, we used the following approach to extract relevant
 information to address our research questions.
 [...] we extracted the lines of code (LOC) information 
 for the projects [...] then we discarded projects with no 
 lines of code  
*/

void main(){
//Evolution of the Practice of Software Testing in Java Projects
    //Declaration of Metadata
    Metadata<String> url = new Metadata<>("id",String.class);
    Metadata<String> language = new Metadata<>("language",String.class);
    Metadata<Map<Integer,Long>> commitNbPerYear = new Metadata<>("commitNbPerYear",Map.class);
    Metadata<Integer> loc = new Metadata<>("loc", Integer.class);
  
    //Workflow Declaration and Execution
    //Filter out non java project
    filterOperator(language.boolConstraint(x -> x.equals("JAVA")))
    .chain(partitionOperator(                      
                    //Parameterized Operator used to create each subset of partion,
                    //here with different "years" values 
                    parameterizedOperators(year-> //filter out repo without a commit in the year
                                                  filterOperator(commitNbPerYear                             
                                                                    .boolConstraint(x -> x.get(year)>0))
                                                  ////Random sampling of 20k repo      
                                                  .chain(randomSelectionOperator(20000))          
                                                  //Compute loc metadata
                                                  .addMetadata(new LocMetadataLoader())                       
                                                  //Filter out repo having 0 loc
                                                  .chain(filterOperator(loc.boolConstraint(x -> x > 0))),     
                                                  //Value that will be used to parition with above operator
                                        2012,2013,2014,2015,2016,2017,2018,2019,2020)))           //Define all the years used for the partition 
    .input(jsonLoader("input.json",url))
    .execute();
};

class LocMetadataLoader  implements IMetadataLoader{
    @Override
    public void loadMetadata(Element e) {
        if (e instanceof Repository){
            //Call exteranal scripts computing LOC metadata
        }
    }
}
    





 

