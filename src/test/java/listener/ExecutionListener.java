package listener;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.testng.IExecutionListener;
import report.AllureManager;
import util.CommandUtil;
import util.Config;

import java.io.IOException;

@Slf4j
public class ExecutionListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        try {
            Config.loadConfig();
            Config.loadProfile();
            AllureManager allureManager = new AllureManager();
            allureManager.setAllureEnvironment();
            allureManager.copyHistoryTrend();
            allureManager.setAllureExecutor();
        } catch (IOException e) {
            throw new RuntimeException("La configuración no se pudo cargar");
        }

    }

    @Override
    public void onExecutionFinish() {
        if(Config.isOpenReportAuto()){
            try{
                CommandUtil.sendCommand("\"\" results.bat");
            } catch (IOException | InterruptedException e){
                log.error(e.getMessage(), e);
            }
        }
    }
}
