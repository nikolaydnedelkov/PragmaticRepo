package spotify.song.repository;

import lombok.Data;

import java.util.Date;

@Data
public class Song {
    private long id;
    private String name;
    private Date releaseDate;
    private int songLength;
    private int artistId;
}
