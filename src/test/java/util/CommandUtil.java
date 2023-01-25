package util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

@Slf4j
public class CommandUtil {


    public static int sendCommand(String command) throws IOException, InterruptedException {
        String runtimeCommand = String.format("cmd.exe /c start %s", command);
        Process process = Runtime.getRuntime().exec(runtimeCommand);
        try(InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = reader.readLine()) != null){
                log.info(line);
            }
            return process.waitFor();
        }
    }
}
