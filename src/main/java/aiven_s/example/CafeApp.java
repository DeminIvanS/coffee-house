package aiven_s.example;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CafeApp  {

    public static void main(String[] args) {
        SpringApplication.run(CafeApp.class, args);

    }
}