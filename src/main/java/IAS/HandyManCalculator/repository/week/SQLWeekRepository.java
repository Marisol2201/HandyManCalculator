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

@Repository
public class SQLWeekRepository implements WeekRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SQLWeekRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void storeWeek(Week week) {
        String sql = "INSERT INTO WEEKS(id, hours) VALUES (?, ?)";
        PreparedStatementSetter preparedStatementSetter = ps -> {
            ps.setString(1, week.getId());
            ps.setShort(2, week.getHours());
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }


    public List<Week> listWeeks() {
        String sql = "SELECT * FROM WEEKS";
        return jdbcTemplate.query(sql, this::weekRowMapper);
    }

    private Week weekRowMapper(ResultSet resultSet, int rowNum) throws SQLException {
        String id = resultSet.getString("id");
        short hours = resultSet.getShort("hours");
        return new Week(id, hours);
    }


    public Optional<Week> findWeekById(String id) {
        String sql = "SELECT * FROM WEEKS WHERE id = ?";
        PreparedStatementSetter setter = ps -> ps.setString(1, id);
        List<Week> weeks = jdbcTemplate.query(sql, setter, this::weekRowMapper);
        Week unsafeWeek = DataAccessUtils.singleResult(weeks);
        return Optional.ofNullable(unsafeWeek);
    }

    public void updateWeek(Week weekUpdate) {
        String sql = "UPDATE WEEKS SET hours = :hours WHERE id = :id";
        Map<String, Object> parameters = Map.of(
                "id", weekUpdate.getId(),
                "hours", weekUpdate.getHours()
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    public void deleteWeek(String id) {
        String sql = "DELETE FROM WEEKS WHERE id = ?";
        PreparedStatementSetter setter = ps -> ps.setString(1, id);
        jdbcTemplate.update(sql, setter);
    }
}
