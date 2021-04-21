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
        String sql = "INSERT INTO WEEKS(id, totalWeekHours, totalWeekNormalHours, weekNormalDaytimeHours," +
                "weekNormalNightHours, sundayNormalHours, totalWeekExtraHours, weekExtraDaytimeHours," +
                "weekExtraNightHours, sundayExtraHours) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatementSetter preparedStatementSetter = ps -> {
            ps.setString(1, week.getId());
            ps.setShort(2, week.getTotalWeekHours());
            ps.setShort(3, week.getTotalWeekNormalHours());
            ps.setShort(4, week.getWeekNormalDaytimeHours());
            ps.setShort(5, week.getWeekNormalNightHours());
            ps.setShort(6, week.getSundayNormalHours());
            ps.setShort(7, week.getTotalWeekExtraHours());
            ps.setShort(8, week.getWeekExtraDaytimeHours());
            ps.setShort(9, week.getWeekExtraNightHours());
            ps.setShort(10, week.getSundayExtraHours());
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }


    public List<Week> listWeeks() {
        String sql = "SELECT * FROM WEEKS";
        return jdbcTemplate.query(sql, this::weekRowMapper);
    }

    private Week weekRowMapper(ResultSet resultSet, int rowNum) throws SQLException {
        String id = resultSet.getString("id");
        short totalWeekHours = resultSet.getShort("totalWeekHours");
        short totalWeekNormalHours = resultSet.getShort("totalWeekNormalHours");
        short weekNormalDaytimeHours = resultSet.getShort("weekNormalDaytimeHours");
        short weekNormalNightHours = resultSet.getShort("weekNormalNightHours");
        short sundayNormalHours = resultSet.getShort("sundayNormalHours");
        short totalWeekExtraHours = resultSet.getShort("totalWeekExtraHours");
        short weekExtraDaytimeHours = resultSet.getShort("weekExtraDaytimeHours");
        short weekExtraNightHours = resultSet.getShort("weekExtraNightHours");
        short sundayExtraHours = resultSet.getShort("sundayExtraHours");
        return new Week(id, totalWeekHours, totalWeekNormalHours, weekNormalDaytimeHours, weekNormalNightHours,
                sundayNormalHours, totalWeekExtraHours, weekExtraDaytimeHours, weekExtraNightHours, sundayExtraHours);
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
                "hours", weekUpdate.getTotalWeekHours()
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    public void deleteWeek(String id) {
        String sql = "DELETE FROM WEEKS WHERE id = ?";
        PreparedStatementSetter setter = ps -> ps.setString(1, id);
        jdbcTemplate.update(sql, setter);
    }
}
