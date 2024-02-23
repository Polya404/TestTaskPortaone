import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class Utils {
    public List<Long> readFromFile(String fileName) {
        List<Long> list = new ArrayList<>();
        try {
            ClassLoader classLoader = Utils.class.getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            for (String line : lines) {
                Long number = Long.parseLong(line.trim());
                list.add(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
