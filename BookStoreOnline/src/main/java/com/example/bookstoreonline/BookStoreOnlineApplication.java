package com.example.bookstoreonline;

import com.example.bookstoreonline.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class BookStoreOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreOnlineApplication.class, args);
    }

}
