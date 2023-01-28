package FileUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ConfigReader {
    private static final String defaultConfigPath = "./config.txt";

    public static ConfigData readConfig(String path) throws IOException {
        if (path.isEmpty()) {
            path = defaultConfigPath;
        }
        boolean isIncluded = false;
        Set<String> includedPaths = new HashSet<>();
        Set<String> excludedPaths = new HashSet<>();
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String token;

        while ((token = reader.readLine()) != null) {
            switch (token) {
                case "include" -> isIncluded = true;
                case "exclude" -> isIncluded = false;
                default -> {
                    if (isIncluded) {
                        includedPaths.add(token);
                    } else {
                        excludedPaths.add(token);
                    }
                }
            }
        }
        return new ConfigData(includedPaths, excludedPaths);
    }
}
