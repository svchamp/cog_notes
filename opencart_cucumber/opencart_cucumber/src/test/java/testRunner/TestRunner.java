package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					//executes all feature files
					//features= {".//Features/"},
		
					//features= {".//Features/Login.feature"},
					//features= {".//Features/LoginDDTExcel.feature"},
		
					//run 2 specific feature files
					features= {".//Features/Login.feature",".//Features/Registration.feature"},
					
					//for running failed scenarios
					//features= {"@target/rerun.txt"},
					
					//glue has package name of stepDefinitions files
					glue="stepDefinitions",
					
					//for generating report
					//pretty is default Junit report
					//html:reports/myreport.html- Cucumber report
					//rerun:target/rerun.txt-> scenarios that failed in prev execution are stored in target/rerun.txt
					//aventstack generates a good extent report
					plugin= {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
					
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					//when dryrun=true then methods will actually not be executed. It will only check 
					//if each step has a step definition method or not
					
					monochrome=true,    // to avoid junk characters in output
					
					publish=true   // to publish report in cucumber server- only for cucumber report
					
					//tags="@sanity"  // this will execute scenarios tagged with @sanity
					//tags="@regression"
					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		)
public class TestRunner {

		}
