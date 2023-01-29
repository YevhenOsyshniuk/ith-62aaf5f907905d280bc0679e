package ua.ithillel.lesson31.homework.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Table(name = "student")
@Getter
@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;
    @Column(nullable = false)
    String name;
    @Column(unique = true, nullable = false)
    String email;
}
