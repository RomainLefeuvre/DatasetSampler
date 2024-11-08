import fr.inria.diverse.model.metadata.Metadata;

import static fr.inria.diverse.model.element.loader.LoaderFactory.*;
import static fr.inria.diverse.model.element.writter.WritterFactory.*;
import static fr.inria.diverse.model.operator.OperatorFactory.*;

//Keep the Ball Rolling: Analyzing Release Cadence in GitHub Projects
//  doi: 10.1109/MSR59073.2023.00058

// Workflow description in the paper :
/* 
  "
We collected the data for Go, Java, Python, and Ruby projects
omitting toy-like, inactive, or very recent projects. Thus, our
dataset contains projects with at least 150 commits, 20 stars,
10 contributors, and 10 files of the primary programming
languages while having the first commit before 2019 and the
last commit in 2021
  "
 */

void main(){
    var url = Metadata.ofString("id");
    var primaryLanguage = Metadata.ofString("primaryLanguage");
    var authorNb = Metadata.ofInteger("authorNb");
    var stars = Metadata.ofInteger("stars");
    var commitNb = Metadata.ofInteger("commitNb");
    var nbFileInPrimaryLanguage = Metadata.ofInteger("commitNb");
    var availableOnGithub = Metadata.ofBoolean("availableOnGithub");
    var dateOfFirstCommit = Metadata.ofLong("dateOfFirstCommit");
    var dateOfLastCommit = Metadata.ofLong("dateOfLastCommit");


    filterOperator(primaryLanguage.boolConstraint(
                                  Set.of("java", "python", "ruby", "Go")::contains)
              .and(commitNb.boolConstraint(x->x>150))
              .and(availableOnGithub.boolConstraint(x->x))
              .and(stars.boolConstraint(x->x>20))
              .and(authorNb.boolConstraint(x->x>10)
              .and(nbFileInPrimaryLanguage.boolConstraint(x->x>10))
              .and(dateOfFirstCommit.boolConstraint(
                                          x->x<new Date(2019, 01, 01).getTime()))
              .and(dateOfLastCommit.boolConstraint(
                                          x->(new Date(x)).getYear()==2021))))       
    .input(jsonLoader("input.json",url,primaryLanguage,authorNb,stars,commitNb,nbFileInPrimaryLanguage,
                     availableOnGithub,dateOfFirstCommit,dateOfLastCommit))
    .execute();

}
    





 

