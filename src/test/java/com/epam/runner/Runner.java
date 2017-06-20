package com.epam.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features"
		,glue={"com.epam.stepDefination"}
		,plugin = {"html:target/cucumber-html-report"})
public class Runner {

}


