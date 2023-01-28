package FileUtils;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;


public class FileParser {
    private static String readFileAsBlock(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static FileData readTokensFromFile(String path) throws IOException {
        Set<String> stringTokens = new HashSet<>();
        Set<Integer> integerTokens = new HashSet<>();
        FileReader fileReader = new FileReader(path);
        StreamTokenizer tokenizer = new StreamTokenizer(fileReader);

        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            switch (tokenizer.ttype) {
                case StreamTokenizer.TT_NUMBER -> integerTokens.add((int) tokenizer.nval);
                case StreamTokenizer.TT_WORD -> stringTokens.add(tokenizer.sval);
            }
        }
        return new FileData(stringTokens, integerTokens);
    }
}
