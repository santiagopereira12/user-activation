package com.project.user.activation.persistence.repository;

import com.project.user.activation.persistence.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<UserEntity, Integer> {
}
