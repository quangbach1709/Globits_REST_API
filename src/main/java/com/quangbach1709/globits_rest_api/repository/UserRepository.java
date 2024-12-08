package com.quangbach1709.globits_rest_api.repository;

import com.quangbach1709.globits_rest_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
