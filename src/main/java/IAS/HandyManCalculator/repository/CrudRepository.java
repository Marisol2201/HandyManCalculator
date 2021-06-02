package IAS.HandyManCalculator.repository;

import IAS.HandyManCalculator.domain.Week;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// This is an exploration class
public interface CrudRepository<TYPE, ID> {
    Mono<Object> store(TYPE item);

    Mono<Object> update(TYPE item);

    Mono<Object> delete(ID id);

    Mono<Week> findById(ID id);

    Flux<Week> list();
}
