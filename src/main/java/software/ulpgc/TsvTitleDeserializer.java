package software.ulpgc;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TsvTitleDeserializer implements TitleDeserializer {
    @Override
    public Optional<Title> deserialize(String line) {
        String[] columns = line.split("\t");
        if (columns.length < 9) {
            return Optional.empty();
        }

        try {
            return Optional.of(new Title(
                    columns[0],
                    Title.TitleType.valueOf(columns[1].toUpperCase()),
                    columns[2],
                    columns[3],
                    columns[4].equals("1"),
                    parseYear(columns[5]),
                    parseYear(columns[6]),
                    Optional.empty(),
                    Arrays.stream(columns[8].split(","))
                            .map(String::trim)
                            .map(Title.Genre::valueOf)
                            .collect(Collectors.toList())
            ));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private Optional<Year> parseYear(String column) {
        return column.equals("\\N") ? Optional.empty() : Optional.of(Year.parse(column));
    }
}