package spotify.song.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spotify.song.repository.mapper.SongRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SongRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public SongRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(final Song song) {
        final String sql = "INSERT INTO songs (name, release_date, song_length, artist_id) "
                + "VALUES (:name, :release_date, :song_length, :artist_id)";

        final Map<String, Object> params = new HashMap<>();
        params.put("name", song.getName());
        params.put("release_date", song.getReleaseDate());
        params.put("song_length", song.getSongLength());
        params.put("artist_id", song.getArtistId());

        jdbcTemplate.update(sql, params);
    }

    public void delete(final long id) {
        final String sql = "DELETE FROM songs WHERE id = " + id;
        jdbcTemplate.update(sql, new HashMap<>());
    }

    public Song get(final long id) {
        final String sql = "SELECT * FROM songs WHERE id = " + id;

        return jdbcTemplate.queryForObject(sql, new HashMap<>(), new SongRowMapper());
    }

    public List<Song> getAll() {
        final String sql = "SELECT * FROM songs";
        return jdbcTemplate.query(sql, new SongRowMapper());
    }

    public void update(final Song song) {
        final String sql = "UPDATE songs "
                + "SET name = :name,"
                + "release_date = :release_date, "
                + "song_length = :song_length, "
                + "artist_id = :artist_id "
                + "WHERE id = :id";

        final Map<String, Object> params = new HashMap<>();
        params.put("id", song.getId());
        params.put("name", song.getName());
        params.put("song_length", song.getSongLength());
        params.put("artist_id", song.getArtistId());
        params.put("release_date", song.getReleaseDate());

        jdbcTemplate.update(sql, params);
    }
}
