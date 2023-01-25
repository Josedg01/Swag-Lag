package util;

import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class Config {

    private static final Properties PROPS_CONFIG = new Properties();
    private static final Properties PROPS_PROFILE = new Properties();
    public static final String CONFIG_FILE = "config.properties";
    public static final String PROFILE_FILE = "profile.properties";
    public static final String BASE_PATH = System.getProperty("user.dir");

    public static void loadConfig() throws IOException {
        String configPath = getConfigPath(CONFIG_FILE);
        //log.info(configPath);
        PROPS_CONFIG.load(new FileInputStream(configPath));
    }

    public static void loadProfile() throws IOException {
        String configPath = getConfigPath(PROFILE_FILE);
        //log.info(configPath);
        PROPS_PROFILE.load(new FileInputStream(configPath));
    }

    public static String getResourcesPath() {
        return BASE_PATH.concat(File.separator)
                .concat("src")
                .concat(File.separator)
                .concat("test")
                .concat(File.separator)
                .concat("resources")
                .concat(File.separator);
    }

    public static String getConfigPath(String filename){
        return getResourcesPath().concat(filename);
    }

    public static String getDataPath(){
        return getResourcesPath().concat("data").concat(File.separator);
    }

    public static String getUser() {
        return PROPS_PROFILE.getProperty("user");
    }

    public static String getPassword() {
        return PROPS_PROFILE.getProperty("password");
    }

    public static String getHomePage() {
        return PROPS_CONFIG.getProperty("homepage");

    }

    public static boolean getHeadless(){
        return Boolean.parseBoolean(PROPS_CONFIG.getProperty("headless"));
    }

    public static boolean isOpenReportAuto(){
        return Boolean.parseBoolean(PROPS_CONFIG.getProperty("open_report_auto"));
    }

    public static String getBrowser() {
        return PROPS_CONFIG.getProperty("browser");
    }

    public static Integer getTimeout() {
        return Integer.parseInt(PROPS_CONFIG.getProperty("timeout"));

    }
}
