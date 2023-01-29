package ua.ithillel.lesson31.homework.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Table(name = "student")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "email",unique = true, nullable = false)
    String email;
}
