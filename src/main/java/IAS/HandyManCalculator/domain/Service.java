package IAS.HandyManCalculator.domain;
import java.util.Objects;
import java.util.UUID;

public class Service {
    private final UUID idService;
    private final String nameService;

    public Service(UUID idService, String nameService) {
        this.idService = idService;
        this.nameService = nameService;
    }

    public UUID getIdService() {
        return idService;
    }

    public String getNameService() {
        return nameService;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idService=" + idService + '\'' +
                ", nameService='" + nameService + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service that = (Service) o;
        return Objects.equals(idService, that.idService) && Objects.equals(nameService, that.nameService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idService, nameService);
    }
}
