package spotify.song.repository;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(255)")
    private String name;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(columnDefinition = "int")
    private int songLength;

    @Column(columnDefinition = "int")
    private int artistId;
}
