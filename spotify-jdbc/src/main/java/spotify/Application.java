package spotify;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spotify.user.convertor.UserConvertor;

@SpringBootApplication
public class Application {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public UserConvertor userConvertor() { return new UserConvertor(modelMapper());}

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

