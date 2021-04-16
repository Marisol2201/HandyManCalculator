package IAS.HandyManCalculator.domain;
import java.util.Objects;
import java.util.UUID;

public class Week {
    private final UUID idWeek;
    private final String nameWeek;

    public Week(UUID idWeek, String nameWeek) {
        this.idWeek = idWeek;
        this.nameWeek = nameWeek;
    }

    public UUID getIdWeek() {
        return idWeek;
    }

    public String getNameWeek() {
        return nameWeek;
    }

    @Override
    public String toString() {
        return "Week{" +
                "idWeek=" + idWeek + '\'' +
                ", nameWeek='" + nameWeek + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Week that = (Week) o;
        return Objects.equals(idWeek, that.idWeek) && Objects.equals(nameWeek, that.nameWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWeek, nameWeek);
    }
}
