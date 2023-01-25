package listener;

import core.TestBase;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result){
        allureManager.removeParameters();
    }

    @Override
    public void onTestFailure(ITestResult result){
        allureManager.testFailed(result);
        allureManager.removeParameters();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        allureManager.testFailed(result);
        allureManager.removeParameters();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result){
        allureManager.testFailed(result);
        allureManager.removeParameters();
    }

    @Override
    public void onTestSkipped(ITestResult result){
        allureManager.removeParameters();
    }

}
