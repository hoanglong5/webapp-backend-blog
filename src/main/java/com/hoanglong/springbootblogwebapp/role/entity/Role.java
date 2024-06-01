package com.hoanglong.springbootblogwebapp.role.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hoanglong.springbootblogwebapp.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "role",schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();
}
