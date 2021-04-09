package IAS.HandyManCalculator.domain;
import java.util.Objects;
import java.util.UUID;

public class Technician {
    private final UUID idTechnician;
    private final String nameTechnician;

    public Technician(UUID idTechnician, String nameTechnician) {
        this.idTechnician = idTechnician;
        this.nameTechnician = nameTechnician;
    }

    public UUID getIdTechnician() {
        return idTechnician;
    }

    public String getNameTechnician() {
        return nameTechnician;
    }

    @Override
    public String toString() {
        return "Technician{" +
                "idTechnician=" + idTechnician + '\'' +
                ", nameTechnician='" + nameTechnician + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technician that = (Technician) o;
        return Objects.equals(idTechnician, that.idTechnician) && Objects.equals(nameTechnician, that.nameTechnician);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTechnician, nameTechnician);
    }
}
