package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerExample implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Catching the fail");
    }


}
