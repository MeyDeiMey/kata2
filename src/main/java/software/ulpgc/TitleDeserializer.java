package software.ulpgc;
import java.util.Optional;

public interface TitleDeserializer {
    Optional<Title> deserialize(String line);

}