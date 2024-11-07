import fr.inria.diverse.model.metadata.Metadata;
import static fr.inria.diverse.model.operator.OperatorFactory.*;
import static fr.inria.diverse.runtime.loader.LoaderFactory.*;

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
//Declaration of Metadata

    Metadata<String> url = new Metadata<>("id",String.class);
    Metadata<Integer> authorNb = new Metadata<>("authorNb", Integer.class);
    Metadata<String> primaryLanguage = new Metadata<>("primaryLanguage", String.class);
    Metadata<Integer> stars = new Metadata<>("stars", Integer.class);
    Metadata<Integer> commitNb = new Metadata<>("commitNb",Integer.class);
    Metadata<Integer> nbFileInPrimaryLanguage = new Metadata<>("commitNb",Integer.class);
    Metadata<Boolean> availableOnGithub = new Metadata<>("availableOnGithub",Boolean.class);
    Metadata<Long> dateOfFirstCommit = new Metadata<>("dateOfFirstCommit",Long.class);
    Metadata<Long> dateOfLastCommit = new Metadata<>("dateOfLastCommit",Long.class);


    filterOperator(primaryLanguage.boolConstraint(Set.of("java", "python", "ruby", "Go")::contains)
                   .and(commitNb.boolConstraint(x->x>150))
                   .and(availableOnGithub.boolConstraint(x->x))
                   .and(stars.boolConstraint(x->x>20))
                   .and(authorNb.boolConstraint(x->x>10)
                   .and(nbFileInPrimaryLanguage.boolConstraint(x->x>10))
                   .and(dateOfFirstCommit.boolConstraint(x->x<new Date(2019, 01, 01).getTime()))
                   .and(dateOfLastCommit.boolConstraint(x->(new Date(x)).getYear()==2021))
                   )
    )
    .input(jsonLoader("input.json",url))
    .execute();

}
    





 

