package IAS.HandyManCalculator.repository.week;

import IAS.HandyManCalculator.domain.Week;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SQLWeekRepository implements IAS.HandyManCalculator.repository.week.WeekRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SQLWeekRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void storeWeek(Week week) {
        String sql = "INSERT INTO WEEKS(id, name) VALUES (?, ?)";
        PreparedStatementSetter preparedStatementSetter = ps -> {
            ps.setString(1, week.getId().toString());
            ps.setString(2, week.getName());
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }


    public List<Week> listWeeks() {
        String sql = "SELECT * FROM WEEKS";
        return jdbcTemplate.query(sql, this::weekRowMapper);
    }

    private Week weekRowMapper(ResultSet resultSet, int rowNum) throws SQLException {
        String idString = resultSet.getString("id");
        String name = resultSet.getString("name");
        UUID id = UUID.fromString(idString);
        return new Week(id, name);
    }


    public Optional<Week> findWeekById(UUID id) {
        String sql = "SELECT * FROM WEEKS WHERE id = ?";
        PreparedStatementSetter setter = ps -> ps.setString(1, id.toString());
        List<Week> weeks = jdbcTemplate.query(sql, setter, this::weekRowMapper);
        Week unsafeWeek = DataAccessUtils.singleResult(weeks);
        return Optional.ofNullable(unsafeWeek);
    }

    public void updateWeek(Week weekUpdate) {
        String sql = "UPDATE WEEKS SET name = :name WHERE id = :id";
        Map<String, Object> parameters = Map.of(
                "id", weekUpdate.getId().toString(),
                "name", weekUpdate.getName()
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    public void deleteWeek(UUID id) {
        String sql = "DELETE FROM WEEKS WHERE id = ?";
        PreparedStatementSetter setter = ps -> ps.setString(1, id.toString());
        jdbcTemplate.update(sql, setter);
    }
}
