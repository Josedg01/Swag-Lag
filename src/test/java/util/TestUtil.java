package util;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.TypeToken;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestUtil {

    public static String getBrowserLogs(WebDriver driver){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        return logEntries.getAll().stream()
                .map(LogEntry::getMessage)
                .collect(Collectors.joining());
    }

    public static synchronized <T> T jsonToPojo(String jsonFile, Class<T> type){
        FileCommon fileCommon = new FileCommon(Config.getDataPath(), jsonFile);
        String json = fileCommon.read();
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    public static synchronized <T> Object[][] jsonToDataProvider(String jsonFile, Class<T> type){
        T object = jsonToPojo(jsonFile, type);
        return new Object[][]{{object}};
    }

    public static synchronized <T> Object[][] jsonListToDataProvider(String jsonFile, Class<T> type){
        FileCommon fileCommon = new FileCommon(Config.getDataPath(), jsonFile);
        Gson gson = new Gson();
        Type listOfMyClassObject = new TypeToken<ArrayList<T>>(){
        }.getType();
        String json = fileCommon.read();
        List<T> outputList = gson.fromJson(json, listOfMyClassObject);
        return outputList.stream().map(item -> new Object[]{item}).toArray(Object[][]::new);
    }

    public static synchronized <T> Object[][] csvToDataProvider(String csv, Class<T> type){
        Path path = Paths.get(Config.getDataPath(), csv);
        try (Reader reader = Files.newBufferedReader(path)){
            CsvToBean cb = new CsvToBeanBuilder(reader)
                    .withType(type)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<T> outputList = cb.parse();
            return outputList.stream().map(item -> new Object[]{item}).toArray(Object[][]::new);
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Not found CSV".concat(csv));
        }
    }
}
