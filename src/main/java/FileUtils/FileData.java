package FileUtils;

import java.util.Set;

public class FileData {
    Set<String> stringTokens;
    Set<Integer> integerTokens;
    FileData(Set<String> sTokens, Set<Integer> iTokens) {
        stringTokens = sTokens;
        integerTokens = iTokens;
    }
}
