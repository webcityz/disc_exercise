

Step 1: Open Git Bash/command line from your IDE workspace and run the following command to clone project:

	git clone git@github.com:webcityz/disc_exercise.git
	
Step 2: In your choice of IDE, Import the clone as a Maven project 

Step 3: Run maven to generate-sources  i.e maven will download all the dependencies

Step 4:To execute the test, locate RunTests.java that is found in com.features.runner, right click then select Run As TestNG


The approach taken was to focus on the supporting framework rather than just the individual tests.

The following packages were made available:

com.dc.features - containing the feature file

com.dc.pages - containing classes for LandingPage and a Page class with is the parent

com.dc.stepdefinitions - containing the fixtures or glue that implement steps specified in feature file

com.dc.utilities - supporting utilities classes

com.features.runner - the class used to execute the test from an IDE


Other Folders include:

resources: containings the executables for different browsers and the test.properties file that is used to configure the test

logs: A rotating Logfile.log used as an audit trail. All actions carried out under test are logged here

reports: An extent report is created here for every execution. Each report is appended with date and time of execution
