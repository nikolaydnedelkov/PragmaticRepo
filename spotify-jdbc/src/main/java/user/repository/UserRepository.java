package user.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import user.repository.mapper.UserRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(final User user) {
        final String sql = "INSERT INTO users (first_name, last_name, email, birth_date, has_paid_app) "
                + "VALUES (:first_name, :last_name, :email, :birth_date, :has_paid_app)";

        final Map<String, Object> params = new HashMap<>();
        params.put("first_name", user.getFirstName());
        params.put("last_name", user.getLastName());
        params.put("email", user.getEmail());
        params.put("birth_date", user.getBirthDate());
        params.put("has_paid_app", user.isHasPaidApp());

        jdbcTemplate.update(sql, params);
    }

    public void delete(final long id) {
        final String sql = "DELETE FROM users WHERE id = " + id;
        jdbcTemplate.update(sql, new HashMap<>());
    }

    public User get(final long id) {
        final String sql = "SELEC * FROM users WHERE id = " + id;

        return jdbcTemplate.queryForObject(sql, new HashMap<>(), new UserRowMapper());
    }

    public List<User> getAll() {
        final String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public void update(final User user) {
        final String sql = "UPDATE users "
                + "SET first_name = :first_name,"
                + "last_name = :last_name,"
                + "email = :email,"
                + "birth_date = :birth_date "
                + "has_paid_app = :has_paid_app"
                + "WHERE id = :id";

        final Map<String, Object> params = new HashMap<>();
        params.put("id", user.getId());
        params.put("first_name", user.getFirstName());
        params.put("last_name", user.getLastName());
        params.put("email", user.getEmail());
        params.put("birth_date", user.getBirthDate());
        params.put("has_paid_app", user.isHasPaidApp());

        jdbcTemplate.update(sql, params);
    }

}
