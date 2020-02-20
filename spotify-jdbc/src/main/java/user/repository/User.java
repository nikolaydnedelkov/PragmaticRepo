package user.repository;

import lombok.*;

import java.time.LocalDate;

@Data
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private boolean hasPaidApp;
}
