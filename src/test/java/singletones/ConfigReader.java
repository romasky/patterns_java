package singletones;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private static volatile ConfigReader instance;
    /**instance - это переменная класса ConfigReader, и ключевое слово volatile здесь гарантирует, что изменения, внесенные в instance,
     * будут сразу же видны всем другим потокам, которые могут обращаться к этой переменной.
     * Это важно в контексте многопоточной среды, чтобы избежать проблемы "грязного чтения" (dirty reads) и обеспечить актуальное значение
     * переменной между потоками. * */
    private final MyProperties config;
    private ConfigReader() throws IOException {
        // Создаем объект ObjectMapper для преобразования JSON в POJO
        ObjectMapper mapper = new ObjectMapper();

        // Загружаем свойства из файла
        Properties props = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/config.properties"))) {
            props.load(input);
        }

        // Преобразуем свойства в JSON
        String json = mapper.writeValueAsString(props);

        // Преобразуем JSON в POJO класс
        config = mapper.readValue(json, MyProperties.class);
    }

    public static ConfigReader getInstance() throws IOException {
        // Проверяем, был ли уже создан объект
        if (instance == null) {
            synchronized (ConfigReader.class) {             // - это механизм в Java, который обеспечивает синхронизацию доступа к блоку кода или методу между потоками.
                if (instance == null) {
                    instance = new ConfigReader(); //Этот шаблон называется "Double-Checked Locking" и используется для ленивой инициализации объекта в многопоточной среде. Он обеспечивает эффективность, так как синхронизация происходит только при первом создании объекта, и после этого проверка if (instance == null) возвращается false.
                }
            }
        }
        return instance;
    }

    public MyProperties getConfig() {
        return config;
    }
}
