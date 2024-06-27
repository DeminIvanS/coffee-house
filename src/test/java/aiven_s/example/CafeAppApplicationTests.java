package aiven_s.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class CafeAppApplicationTests {
    @Test
    void contextLoads(){
        System.out.println(
                new BCryptPasswordEncoder().encode("admin123")
        );

        System.out.println(
                new BCryptPasswordEncoder().encode("user123")
        );
        System.out.println(new BCryptPasswordEncoder().matches("123",  "$2a$10$v6F3IXAg5rp.S11noP3uPOe8LxTbH6F3Qug4U8fjc8FWH6rmuQFaa"));


    }
}
