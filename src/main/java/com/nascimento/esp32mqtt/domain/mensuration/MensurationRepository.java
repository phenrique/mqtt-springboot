package com.nascimento.esp32mqtt.domain.mensuration;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensurationRepository extends ReactiveCrudRepository<Mensuration, Integer> {
}