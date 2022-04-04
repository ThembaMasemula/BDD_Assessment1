package features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//java//features",
        //format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/WebReports/Web.html"},
        glue={"stepdefinition"},
        tags = "@BookHotel"
)
public class hotelrunner
{
}
