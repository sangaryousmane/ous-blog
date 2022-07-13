package com.example.jpa.relationship1;

import com.example.jpa.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Course")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence")
    private Long id;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "course_FK")),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "student_FK")))
    List<Student> students=new ArrayList<>();

    public Course(String title, Integer credit) {
        this.title = title;
        this.credit = credit;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }
}
