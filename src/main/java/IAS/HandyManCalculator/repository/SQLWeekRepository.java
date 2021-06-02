package IAS.HandyManCalculator.repository;

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
        String sql = "INSERT INTO WEEKS(id, technicianId, serviceId, totalWeekHours, totalWeekNormalHours, weekNormalDaytimeHours," +
                "weekNormalNightHours, sundayNormalHours, totalWeekExtraHours, weekExtraDaytimeHours," +
                "weekExtraNightHours, sundayExtraHours) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatementSetter preparedStatementSetter = ps -> {
            ps.setString(1, week.getId());
            ps.setString(2, week.getTechnicianId());
            ps.setString(3, week.getServiceId());
            ps.setShort(4, week.getTotalWeekHours());
            ps.setShort(5, week.getTotalWeekNormalHours());
            ps.setShort(6, week.getWeekNormalDaytimeHours());
            ps.setShort(7, week.getWeekNormalNightHours());
            ps.setShort(8, week.getSundayNormalHours());
            ps.setShort(9, week.getTotalWeekExtraHours());
            ps.setShort(10, week.getWeekExtraDaytimeHours());
            ps.setShort(11, week.getWeekExtraNightHours());
            ps.setShort(12, week.getSundayExtraHours());
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }


    public List<Week> listWeeks() {
        String sql = "SELECT * FROM WEEKS";
        return jdbcTemplate.query(sql, this::weekRowMapper);
    }

    private Week weekRowMapper(ResultSet resultSet, int rowNum) throws SQLException {
        String id = resultSet.getString("id");
        String technicianId = resultSet.getString("technicianId");
        String serviceId = resultSet.getString("serviceId");
        short totalWeekHours = resultSet.getShort("totalWeekHours");
        short totalWeekNormalHours = resultSet.getShort("totalWeekNormalHours");
        short weekNormalDaytimeHours = resultSet.getShort("weekNormalDaytimeHours");
        short weekNormalNightHours = resultSet.getShort("weekNormalNightHours");
        short sundayNormalHours = resultSet.getShort("sundayNormalHours");
        short totalWeekExtraHours = resultSet.getShort("totalWeekExtraHours");
        short weekExtraDaytimeHours = resultSet.getShort("weekExtraDaytimeHours");
        short weekExtraNightHours = resultSet.getShort("weekExtraNightHours");
        short sundayExtraHours = resultSet.getShort("sundayExtraHours");
        return new Week(id, technicianId, serviceId, totalWeekHours, totalWeekNormalHours, weekNormalDaytimeHours, weekNormalNightHours,
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
        String sql = "UPDATE WEEKS SET totalWeekHours = :totalWeekHours, totalWeekNormalHours = :totalWeekNormalHours, " +
                "weekNormalDaytimeHours = :weekNormalDaytimeHours, weekNormalNightHours = :weekNormalNightHours, " +
                "sundayNormalHours = :sundayNormalHours, totalWeekExtraHours = :totalWeekExtraHours, " +
                "weekExtraDaytimeHours = :weekExtraDaytimeHours, weekExtraNightHours = :weekExtraNightHours," +
                "sundayExtraHours = :sundayExtraHours WHERE id = :id";
        Map<String, Object> parameters = Map.of(
                "id", weekUpdate.getId(),
                "totalWeekHours", weekUpdate.getTotalWeekHours(),
                "totalWeekNormalHours", weekUpdate.getTotalWeekNormalHours(),
                "weekNormalDaytimeHours", weekUpdate.getWeekNormalDaytimeHours(),
                "weekNormalNightHours", weekUpdate.getWeekNormalNightHours(),
                "sundayNormalHours", weekUpdate.getSundayNormalHours(),
                "totalWeekExtraHours", weekUpdate.getTotalWeekExtraHours(),
                "weekExtraDaytimeHours", weekUpdate.getWeekExtraDaytimeHours(),
                "weekExtraNightHours", weekUpdate.getWeekExtraNightHours(),
                "sundayExtraHours", weekUpdate.getSundayExtraHours()
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    public void deleteWeek(String id) {
        String sql = "DELETE FROM WEEKS WHERE id = ?";
        PreparedStatementSetter setter = ps -> ps.setString(1, id);
        jdbcTemplate.update(sql, setter);
    }
}
