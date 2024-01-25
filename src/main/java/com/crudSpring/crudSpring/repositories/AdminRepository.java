package com.crudSpring.crudSpring.repositories;

import com.crudSpring.crudSpring.models.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminModel, Long> {
}
