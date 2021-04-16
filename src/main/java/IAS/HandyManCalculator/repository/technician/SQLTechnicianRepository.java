package IAS.HandyManCalculator.repository.technician;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import IAS.HandyManCalculator.domain.Technician;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SQLTechnicianRepository implements IAS.HandyManCalculator.repository.technician.TechnicianRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SQLTechnicianRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void storeTechnician(Technician technician) {
        String sql = "INSERT INTO TECHNICIANS(id, name) VALUES (?, ?)";
        PreparedStatementSetter preparedStatementSetter = ps -> {
            ps.setString(1, technician.getId().toString());
            ps.setString(2, technician.getName());
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }


    public List<Technician> listTechnicians() {
        String sql = "SELECT * FROM TECHNICIANS";
        return jdbcTemplate.query(sql, this::technicianRowMapper);
    }

    private Technician technicianRowMapper(ResultSet resultSet, int rowNum) throws SQLException {
        String idString = resultSet.getString("id");
        String name = resultSet.getString("name");
        UUID id = UUID.fromString(idString);
        return new Technician(id, name);
    }


    public Optional<Technician> findTechnicianById(UUID id) {
        String sql = "SELECT * FROM TECHNICIANS WHERE id = ?";
        PreparedStatementSetter setter = ps -> ps.setString(1, id.toString());
        List<Technician> technicians = jdbcTemplate.query(sql, setter, this::technicianRowMapper);
        Technician unsafeTechnician = DataAccessUtils.singleResult(technicians);
        return Optional.ofNullable(unsafeTechnician);
    }

    public void updateTechnician(Technician technicianUpdate) {
        String sql = "UPDATE TECHNICIANS SET name = :name WHERE id = :id";
        Map<String, Object> parameters = Map.of(
                "id", technicianUpdate.getId().toString(),
                "name", technicianUpdate.getName()
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    public void deleteTechnician(UUID id) {
        String sql = "DELETE FROM TECHNICIANS WHERE id = ?";
        PreparedStatementSetter setter = ps -> ps.setString(1, id.toString());
        jdbcTemplate.update(sql, setter);
    }
}
