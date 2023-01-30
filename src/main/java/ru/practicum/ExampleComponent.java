package ru.practicum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExampleComponent {
 private final String message;
    @Autowired
    public ExampleComponent(@Value("${message}") String message) {
       this.message = message; // в параметре message будет значение из файла с настройками
    }


}
