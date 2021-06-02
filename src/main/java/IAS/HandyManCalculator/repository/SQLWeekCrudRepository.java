package IAS.HandyManCalculator.repository;

import IAS.HandyManCalculator.domain.Week;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SQLWeekCrudRepository implements WeekCRUDRepository {
    @Override
    public Mono<Object> store(Week item) {
        return Mono.empty();
    }

    @Override
    public Mono<Object> update(Week item) {
        return Mono.empty();
    }

    @Override
    public Mono<Object> delete(String id) {
        return Mono.empty();
    }

    @Override
    public Mono<Week> findById(String id) {
        return Mono.empty();
    }

    @Override
    public Flux<Week> list() {
        return null;
    }
}
