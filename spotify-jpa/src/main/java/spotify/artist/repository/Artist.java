package spotify.artist.repository;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(255)")
    private String firstName;

    @Column(columnDefinition = "varchar(255)")
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(columnDefinition = "varchar(255)")
    private String genre;
}
