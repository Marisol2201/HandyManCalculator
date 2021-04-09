package IAS.HandyManCalculator.test;

import IAS.HandyManCalculator.domain.Service;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ServiceDatabase {
    private final List<Object> info = new ArrayList<>();

    //post
    public void insertDataService(Object item) {
        info.add(item);
    }

    //get list
    public List<Object> listDataService() {
        return info;
    }

    //delete
    public void deleteDataService(Object item) {
        info.remove(item);
    }

    //update-put
    public Object updateDataService(Object item) {
        info.add(item);
        return item;
    }

    //get one
    public Object getOneDataService(int item) {
        return info.get(item);
    }

    @PostConstruct
    public void init() {
        info.add(new Service(UUID.randomUUID(), "Electrics"));
        info.add(new Service(UUID.randomUUID(), "Carpentry"));
        info.add(new Service(UUID.randomUUID(), "Repairing"));
    }
}
