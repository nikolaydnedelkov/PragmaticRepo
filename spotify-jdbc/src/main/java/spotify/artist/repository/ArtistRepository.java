package spotify.artist.repository;

import spotify.artist.repository.mapper.ArtistRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spotify.song.repository.Song;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ArtistRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ArtistRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(final Artist artist) {
        final String sql = "INSERT INTO artists (first_name, last_name, birth_date, genre) "
                + "VALUES (:first_name, :last_name, :birth_date, :genre)";

        final Map<String, Object> params = new HashMap<>();
        params.put("first_name", artist.getFirstName());
        params.put("last_name", artist.getLastName());
        params.put("birth_date", artist.getBirthDate());
        params.put("genre", artist.getGenre());

        jdbcTemplate.update(sql, params);
    }

    public void delete(final long id) {
        final String sql = "DELETE FROM artists WHERE id = " + id;
        jdbcTemplate.update(sql, new HashMap<>());
    }

    public Artist get(final long id) {
        final String sql = "SELECT * FROM artists WHERE id = " + id;

        return jdbcTemplate.queryForObject(sql, new HashMap<>(), new ArtistRowMapper());
    }

    public List<Artist> getAll() {
        final String sql = "SELECT * FROM artists";
        return jdbcTemplate.query(sql, new ArtistRowMapper());
    }

    public void update(final Artist artist) {
        final String sql = "UPDATE artists "
                + "SET first_name = :first_name,"
                + "last_name = :last_name,"
                + "genre = :genre,"
                + "birth_date = :birth_date "
                + "WHERE id = :id";

        final Map<String, Object> params = new HashMap<>();
        params.put("id", artist.getId());
        params.put("first_name", artist.getFirstName());
        params.put("last_name", artist.getLastName());
        params.put("genre", artist.getGenre());
        params.put("birth_date", artist.getBirthDate());

        jdbcTemplate.update(sql, params);
    }

    public void addSong(Song song) {
        final String sql = "INSERT INTO songs (name, release_date, song_length, artist_id) "
                + "VALUES (:name, :release_date, :song_length, :artist_id)";

        final Map<String, Object> params = new HashMap<>();
        params.put("name", song.getName());
        params.put("release_date", song.getReleaseDate());
        params.put("song_length", song.getSongLength());
        params.put("artist_id", song.getArtistId());

        jdbcTemplate.update(sql, params);
    }

    public void deleteSong(final long id) {
        final String sql = "DELETE FROM songs WHERE id = " + id;
        jdbcTemplate.update(sql, new HashMap<>());
    }

    public void updateSong(final Song song) {
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
