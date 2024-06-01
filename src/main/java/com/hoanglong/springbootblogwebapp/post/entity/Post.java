package com.hoanglong.springbootblogwebapp.post.entity;

import com.hoanglong.springbootblogwebapp.reaction.entity.Reaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "post",schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "content",nullable = false)
    private String content;
    @ElementCollection
    private Set<String> tags = new HashSet<>();
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
    @OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE)
    private Set<Reaction> reactions = new HashSet<>();
}
