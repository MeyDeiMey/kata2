package software.ulpgc;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/title.basics.tsv");
        TitleReader reader = new TsvTitleReader(file, true);
        List<Title> titles = reader.read();
    }
}