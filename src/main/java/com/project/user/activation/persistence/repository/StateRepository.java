package com.project.user.activation.persistence.repository;

import com.project.user.activation.persistence.entity.StateEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface StateRepository extends ListCrudRepository<StateEntity, Integer> {
}
