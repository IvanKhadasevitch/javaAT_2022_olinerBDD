package by.khadasevich.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@smoke",
        glue = "by.khadasevich.bdd.steps",
        features = "classpath:by.khadasevich.bdd.features"
//        features = "classpath:by/khadasevich/bdd/features"
)
public class OnlinerTestRunner {
}
