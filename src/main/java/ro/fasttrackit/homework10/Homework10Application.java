package ro.fasttrackit.homework10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Homework10Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework10Application.class, args);
    }


//    @Bean
//    CommandLineRunner startup(LocationRepository repo) {
//        return args -> {
//            repo.saveAll(List.of(
//                  Location.builder()
//                          .city("Oradea")
//                          .build(),
//                    Location.builder()
//                            .city("Cluj-Napoca")
//                            .build(),
//                    Location.builder()
//                            .city("Timisoara")
//                            .build()
//            ));
//        };
//    }
}
