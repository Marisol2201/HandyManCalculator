package IAS.HandyManCalculator.repository;
import org.springframework.stereotype.Repository;
import IAS.HandyManCalculator.domain.Technician;
import IAS.HandyManCalculator.test.TechnicianDatabase;
import java.util.List;

@Repository
public class TechnicianRepository {
    private final TechnicianDatabase database;

    // DEPENDENCY INVERSION
    public TechnicianRepository(TechnicianDatabase technicianDatabase) {
        this.database = technicianDatabase;
    }

    //post
    public void createTechnician(Technician transaction) {
        database.insertDataTechnician(transaction);
    }

    //get list
    public List<Object> listTechnician() {
        return database.listDataTechnician();
    }

    //delete
    public void deleteTechnician(Technician transaction) {
        database.deleteDataTechnician(transaction);
    }

    //put(update)
    public Object updateTechnician(Technician transaction) {
        return database.updateDataTechnician(transaction);
    }

    //get one
    public Object getOneTechnician(int id) {
        return database.getOneDataTechnician(id);
    }
}
