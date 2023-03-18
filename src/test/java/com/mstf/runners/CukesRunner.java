package com.mstf.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber-report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/mstf/step_definitions",
        dryRun = false, //when true results will show snippets that are incomplete
        tags = ""


)
public class CukesRunner {
}
