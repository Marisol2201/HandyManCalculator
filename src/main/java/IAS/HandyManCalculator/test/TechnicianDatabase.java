package IAS.HandyManCalculator.test;
import org.springframework.stereotype.Component;
import IAS.HandyManCalculator.domain.Technician;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class TechnicianDatabase {
    private final List<Object> data = new ArrayList<>();

    //post
    public void insertDataTechnician(Object item) {
        data.add(item);
    }

    //get list
    public List<Object> listDataTechnician() {
        return data;
    }

    //delete
    public void deleteDataTechnician(Object item) {
        data.remove(item);
    }

    //update-put
    public Object updateDataTechnician(Object item) {
        data.add(item);
        return item;
    }

    //get one
    public Object getOneDataTechnician(int item) {
        return data.get(item);
    }

    @PostConstruct
    public void init() {
        data.add(new Technician(UUID.randomUUID(), "Chongo Ramírez"));
        data.add(new Technician(UUID.randomUUID(), "Tha Pork"));
        data.add(new Technician(UUID.randomUUID(), "Pepito Perez"));
    }
}
