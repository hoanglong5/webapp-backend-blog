package com.hoanglong.springbootblogwebapp.user.entity;

import com.hoanglong.springbootblogwebapp.reaction.entity.Reaction;
import com.hoanglong.springbootblogwebapp.role.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "users",schema = "public")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "active",columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isActive;
    @CreatedDate
    @Column(name = "created_date",updatable = false)
    private LocalDate createdDate;
    @CreatedBy
    @Column(name = "created_by",updatable = false)
    private UUID createdBy;
    @LastModifiedDate
    @Column(name = "last_modified_date",updatable = false)
    private LocalDate modifiedDate;
    @LastModifiedBy
    @Column(name = "last_modified_by",updatable = false)
    private UUID modifiedBy;
    @ManyToOne()
    @JoinColumn(name = "role_id",nullable = false)
    private Role role;
    @OneToMany(mappedBy = "user")
    private Set<Reaction> reactions = new HashSet<>();
}
