package com.hoanglong.springbootblogwebapp.user.entity;

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
import java.util.UUID;
@Entity
@Table(name = "user",schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "fullname",nullable = false)
    private String fullName;
    @Column(name = "active",nullable = false,columnDefinition = "BOOLEAN DEFAULT FALSE")
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

}
