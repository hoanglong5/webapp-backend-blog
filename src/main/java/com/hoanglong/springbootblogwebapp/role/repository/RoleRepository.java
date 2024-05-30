package com.hoanglong.springbootblogwebapp.role.repository;

import com.hoanglong.springbootblogwebapp.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
}
