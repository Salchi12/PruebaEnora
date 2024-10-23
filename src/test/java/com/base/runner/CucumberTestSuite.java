package com.base.runner;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src/test/resources/feature",
                plugin = {"pretty", "json:target/cucumber/cucumber.json"},
                glue = "com.base.stepdefinition",
                tags =  "@TEST_ENCORA",
                snippets = CucumberOptions.SnippetType.CAMELCASE)


public class CucumberTestSuite{

}