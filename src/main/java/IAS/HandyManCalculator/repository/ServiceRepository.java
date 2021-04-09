package IAS.HandyManCalculator.repository;

import IAS.HandyManCalculator.domain.Service;
import IAS.HandyManCalculator.test.ServiceDatabase;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceRepository {
    private final ServiceDatabase database;

    // DEPENDENCY INVERSION
    public ServiceRepository(ServiceDatabase database) {
        this.database = database;
    }

    //post
    public void createService(Service transaction) {
        database.insertDataService(transaction);
    }

    //get list
    public List<Object> listService() {
        return database.listDataService();
    }

    //delete
    public void deleteService(Service transaction) {
        database.deleteDataService(transaction);
    }

    //put(update)
    public Object updateService(Service transaction) {
        return database.updateDataService(transaction);
    }

    //get one
    public Object getOneService(int id) {
        return database.getOneDataService(id);
    }
}
