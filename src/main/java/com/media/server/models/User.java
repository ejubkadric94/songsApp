package com.media.server.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @Column(unique = true)
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
}
