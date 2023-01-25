package report;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import core.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import util.Config;
import util.TestUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@Slf4j
public class AllureManager {
     public static final String BROWSER_LOG = "Browser Log";
     public static final String EXCEPTION_LOG = "Exception_Log";
     public static final String EXECUTOR_JSON = "executor.json";
     public static final String BUILD_NAME = "Swag Labs";

     @Attachment(value = "page screenshot", type = "image/png")
     public byte[] takeScreenshot(WebDriver driver){
          return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
     }

     @Attachment(value = "{0}", type = "text/plain")
     public String allureLog(String title, String message){
          return message;
     }

     public void testFailed(ITestResult result){
          TestBase test = (TestBase) result.getInstance();
          if(test.driver != null){
               takeScreenshot(test.driver);
               allureLog(BROWSER_LOG, TestUtil.getBrowserLogs(test.driver));
          }
          allureLog(EXCEPTION_LOG, result.getThrowable().getMessage());
     }

     public void setAllureEnvironment(){
          allureEnvironmentWriter(
                  ImmutableMap.<String, String>builder()
                          .put("Browser", Config.getBrowser().toUpperCase())
                          .put("System", System.getProperty("os.name"))
                          .put("URL", Config.getHomePage())
                          .build(), System.getProperty("user.dir")
                          + "/allure-results/");
     }

     public void setAllureExecutor(){
          try{
               File executorJson = new File(getAllureResultsDirectory(), EXECUTOR_JSON);
               Writer writer = new FileWriter(executorJson);
               Gson gson = new Gson();
               String host = InetAddress.getLocalHost().getHostName();
               AllureExecutor executor = new AllureExecutor(host, BUILD_NAME);
               gson.toJson(executor, writer);
               writer.close();
          } catch(IOException e){
               log.error(e.getMessage(), e);
          }
     }

     public void copyHistoryTrend() throws IOException {
          File historyDirectory = new File(getAllureReportHistoryDirectory());
          if(historyDirectory.exists()) {
               File allureResults = new File(getAllureResultsDirectory());
               FileUtils.copyDirectoryToDirectory(historyDirectory, allureResults);
          }
     }

     public void removeParameters(){
          Allure.getLifecycle().updateTestCase(
                  testResult -> testResult.getParameters().clear());
     }

     private String getAllureReportHistoryDirectory(){
          return Config.BASE_PATH
                  .concat(File.separator)
                  .concat("allure-report")
                  .concat(File.separator)
                  .concat("history");
     }

     private String getAllureResultsDirectory(){
          return Config.BASE_PATH
                  .concat(File.separator)
                  .concat("allure-results");
     }

}
