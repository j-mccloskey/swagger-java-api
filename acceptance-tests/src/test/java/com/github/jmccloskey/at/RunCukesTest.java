package com.github.jmccloskey.at;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-html-report", "junit:target/junit-report/junit-report.xml" }, glue = { "com.github.jmccloskey.at.steps" })
public class RunCukesTest {
}