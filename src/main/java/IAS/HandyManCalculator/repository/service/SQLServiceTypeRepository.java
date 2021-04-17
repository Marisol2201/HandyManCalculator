package IAS.HandyManCalculator.repository.service;

import IAS.HandyManCalculator.domain.ServiceType;
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
public class SQLServiceTypeRepository implements ServiceTypeRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SQLServiceTypeRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void storeService(ServiceType service) {
        String sql = "INSERT INTO SERVICES(id, name) VALUES (?, ?)";
        PreparedStatementSetter preparedStatementSetter = ps -> {
            ps.setString(1, service.getId().toString());
            ps.setString(2, service.getName());
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }


    public List<ServiceType> listServices() {
        String sql = "SELECT * FROM SERVICES";
        return jdbcTemplate.query(sql, this::serviceRowMapper);
    }

    private ServiceType serviceRowMapper(ResultSet resultSet, int rowNum) throws SQLException {
        String idString = resultSet.getString("id");
        String name = resultSet.getString("name");
        UUID id = UUID.fromString(idString);
        return new ServiceType(id, name);
    }


    public Optional<ServiceType> findServiceById(UUID id) {
        String sql = "SELECT * FROM SERVICES WHERE id = ?";
        PreparedStatementSetter setter = ps -> ps.setString(1, id.toString());
        List<ServiceType> services = jdbcTemplate.query(sql, setter, this::serviceRowMapper);
        ServiceType unsafeService = DataAccessUtils.singleResult(services);
        return Optional.ofNullable(unsafeService);
    }

    public void updateService(ServiceType serviceUpdate) {
        String sql = "UPDATE SERVICES SET name = :name WHERE id = :id";
        Map<String, Object> parameters = Map.of(
                "id", serviceUpdate.getId().toString(),
                "name", serviceUpdate.getName()
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    public void deleteService(UUID id) {
        String sql = "DELETE FROM SERVICES WHERE id = ?";
        PreparedStatementSetter setter = ps -> ps.setString(1, id.toString());
        jdbcTemplate.update(sql, setter);
    }
}
