package com.fidelity.movil.repository;

import com.fidelity.movil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
