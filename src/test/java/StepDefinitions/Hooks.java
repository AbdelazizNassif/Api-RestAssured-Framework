package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
// When using hooks, u dont have to specify tags in the test runner
// just make them in a class
public class Hooks {

    @Before("@DUMMY")
    public void initTestCaseWithDummyTag()
    {
        System.out.println("**************************************");
        System.out.println("I RUN BEFORE ANY TEST WITH @DUMMY TAG");
        System.out.println("**************************************");
    }
    @Before("@FAST")
    public void initTestCaseWithFastTag()
    {
        System.out.println("**************************************");
        System.out.println("I RUN BEFORE ANY TEST WITH @FAST TAG");
        System.out.println("**************************************");
    }
    @After("@DUMMY")
    public void finalizeTestCaseWithDummyTag()
    {
        System.out.println("**************************************");
        System.out.println("I RUN AFTER ANY TEST WITH @DUMMY TAG");
        System.out.println("**************************************");
    }
    @After("@FAST")
    public void finalizeTestCaseWithFastTag()
    {
        System.out.println("**************************************");
        System.out.println("I RUN AFTER ANY TEST WITH @FAST TAG");
        System.out.println("**************************************");
    }
}
