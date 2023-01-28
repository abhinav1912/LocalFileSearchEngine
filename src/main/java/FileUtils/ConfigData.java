package FileUtils;

import java.util.Set;

public class ConfigData {
    Set<String> includedPaths;
    Set<String> excludedPaths;

    public Set<String> getIncludedPaths() {
        return includedPaths;
    }

    public Set<String> getExcludedPaths() {
        return excludedPaths;
    }

    ConfigData(Set<String> included, Set<String> excluded) {
        includedPaths = included;
        excludedPaths = excluded;
    }

    public void cleanConfig() {
        // TODO: Implement config validation
    }
}
