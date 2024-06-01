package com.hoanglong.springbootblogwebapp.reaction.entity;

import com.hoanglong.springbootblogwebapp.post.entity.Post;
import com.hoanglong.springbootblogwebapp.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.awt.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "reaction",schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @CreatedDate
    @Column(name = "created_date",updatable = false)
    private LocalDate dateCreated;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
