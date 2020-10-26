package com.runner.classes.pkg;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
    features = {
        "src/test/resources/features"
    },
    glue = {
            "com/glue/code/pkg"
    }
)
public class CukeRunner {}