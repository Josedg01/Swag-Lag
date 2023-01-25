package util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class FileCommon {

    private HashMap<String, String> variables = new HashMap<>();
    private Path filePath;

    public FileCommon(String baseDir, String child){
        this.filePath = Paths.get(baseDir, child);
    }

    public String read(){
        String text="";
    try(BufferedReader br = Files.newBufferedReader(this.filePath)){
        text = br.lines().collect(Collectors.joining());
    }catch (IOException e){
        log.error("File not found in File common", e);
    }
    return text;

    }

    public void putBinding(String key, String value){
        variables.put(key, value);
    }

    public String binding(String text){
        for(String key : variables.keySet()){
            String value = variables.get(key);
            String replacement = String.format("${%s}", key);
            text = text.replaceAll(Pattern.quote(replacement), value);
        }
        return text;
    }

    public String readAndBinding(){
        String fileContent = read();
        return binding(fileContent);
    }
}
