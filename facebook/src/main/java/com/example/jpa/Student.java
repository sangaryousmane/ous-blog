package com.example.jpa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "Student")
@Table(
        name = "students",
        uniqueConstraints =
        @UniqueConstraint(name = "student_email_UK", columnNames = "email")
)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String school;

    @Embedded
    private Guardian guardian;

    public Student(String name, String email, String school, Guardian guardian) {
        this.name = name;
        this.email = email;
        this.school = school;
        this.guardian=guardian;
    }

    public Student(String name, String email, String school) {
        this.name = name;
        this.email = email;
        this.school = school;
    }
}
