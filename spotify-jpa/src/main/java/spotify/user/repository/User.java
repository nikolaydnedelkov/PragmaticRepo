package spotify.user.repository;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(255)")
    private String firstName;

    @Column(columnDefinition = "varchar(255)")
    private String lastName;

    @Column(columnDefinition = "varchar(255)")
    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(columnDefinition = "boolean default false")
    private boolean hasPaidApp;

}
