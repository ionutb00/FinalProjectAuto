package propertyUtility;

import java.io.FileInputStream;
import java.util.*;

public class  PropertyUtility {
    private Properties properties;

    public PropertyUtility(String testName) {
        loadFile(testName);
    }
    public void loadFile(String testName){
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/"+testName+"Data.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);

    }
    public List<String> getPropertyAsList(String key){
        String value = getProperty(key);
        if (value.contains(",")){
            return Arrays.asList(value.split(","));
        }
        return new ArrayList<>(List.of(value));
    }
    public Map<String, Object> getAllProperties (){
        Map <String, Object> allProperties = new HashMap<>();
        for (String key : properties.stringPropertyNames()){
            String value = getProperty(key);
            if (value.contains(",")){
                allProperties.put(key, getPropertyAsList(key));
            }
            else {
                allProperties.put(key, value);
            }
        }
        return allProperties;
    }
}
