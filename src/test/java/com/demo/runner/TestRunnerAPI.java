package com.demo.runner;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


/**
 * 
 * Runner class is used for Specific Group of Test cases Execution and below are the ways :
 * 1. If you want to execute Specific Feature/Screen Files, then you need to Specify Feature file path in 'features' attribute, it will execute all the feature files present in that folder.
 * 2. If you want to execute Specific Tags like Regression or MF Module wise, then you need to Specify Tag in 'tags' attribute. It will execute only related Test cases.
 * 
 *
 */
@CucumberOptions(

		
        features = {"src/test/resources/features"},
        glue = {"com.demo.stepdefinition"},
        tags = "@DB",	
        plugin = {
                "pretty",
              
                "json:target/cucumber-reports/CucumberTestReport.json",
                "html:target/cucumber-reports/cucumber-pretty"
                }
        )


public class TestRunnerAPI extends AbstractTestNGCucumberTests
{
	
	
}

