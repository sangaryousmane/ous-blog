package com.example.jpa.relationship1;

import lombok.*;

import javax.persistence.*;

@Entity(name = "CourseMaterial")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence")
    private Long id;
    private String url;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "course_material_FK"))
    @ToString.Exclude
    private Course course;

}
