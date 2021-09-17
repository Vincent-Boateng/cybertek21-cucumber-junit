package com.cybertek.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"

        },
        features = "src/test/resources/features",
        glue = "com/cybertek/step_definitions",
        dryRun = false, // it will not run the test if it is changed to true. True is only for getting the code snippets
        tags = "" //other tag options : "@student or @admin" this is the or logic: it will print any scenarios that have either @student or @admin tag
        // tags = "lbrarian1 and employee" ==> this means I want the scenario that has both @librarian1 and @employee tags to run
)
public class
CukesRunner {
}
