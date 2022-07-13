package com.example.jpa.relationship1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Teacher")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "teacher_course_FK")
    )
    private List<Course> courses;

    public Teacher(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Teacher(Long id){
        this.id=id;
    }
}
