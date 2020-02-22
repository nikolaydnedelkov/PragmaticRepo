package spotify.song.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import spotify.song.repository.Song;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongRowMapper implements RowMapper<Song> {
    @Override
    public Song mapRow(ResultSet rs, int i) throws SQLException {
        final Song song = new Song();
        song.setId(rs.getLong("id"));
        song.setName(rs.getString("name"));
        song.setReleaseDate(rs.getDate("release_date"));
        song.setArtistId(rs.getInt("id"));
        song.setSongLength(rs.getInt("song_length"));
        return song;
    }
}
