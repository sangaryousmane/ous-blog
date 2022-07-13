package com.example.facebook;

import com.example.jpa.Guardian;
import com.example.jpa.Student;
import com.example.jpa.relationship1.Course;
import com.example.jpa.relationship1.CourseMaterial;
import com.example.jpa.relationship1.Teacher;
import com.example.jpa.relationship1.repos.CourseMaterialRepository;
import com.example.jpa.relationship1.repos.CourseRepository;
import com.example.jpa.relationship1.repos.StudentRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
@Commit
public class FacebookApplicationTests {

    private final StudentRepository studentRepository;
    private final CourseMaterialRepository cmRepository;
    private final CourseRepository courseRepository;


    @Autowired
    public FacebookApplicationTests(StudentRepository studentRepository,
                                    CourseMaterialRepository cmRepository,
                                    CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.cmRepository = cmRepository;
        this.courseRepository = courseRepository;
    }


    @Test
    @Order(value = 1)
    void testSaveStudent() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            Guardian guardian = new Guardian(
                    faker.name().firstName(),
                    faker.name().username().concat("@shcompass.com"),
                    String.valueOf(faker.number().randomNumber()));
            Student student = Student.builder()
                    .name(faker.name().fullName())
                    .email(faker.name().username().toLowerCase().concat("@gmail.com"))
                    .school(faker.university().name())
                    .guardian(guardian)
                    .build();
            studentRepository.save(student);
        }
    }

    @Test
    @Order(value = 2)
    void testFindBasedOn() {
        Student student = studentRepository.findByNameContaining("ousmane");
        System.out.println(student);

        System.out.println("ANOTHER: \n");
        int studentId = studentRepository.deleteByStudentId(220L);
        System.out.println(studentId);
    }

    @Test
    @Order(3)
    void testPrintByGuardian() {
        List<Student> guardianName = studentRepository.findByGuardianName("Kimberli");
        guardianName.forEach(System.out::println);
    }

    @Test
    @Order(4)
    void testGetEmail() {
        System.out.println("Using the JPQL below:\n");
        Student byEmail = studentRepository.getStudentByEmail("alec.osinski@yahoo.com");
        System.out.println(byEmail);

        System.out.println("Using the native query below:\n");
        System.out.println(studentRepository.getStudentByEmailNative("alec.osinski@yahoo.com"));

        System.out.println("Below is the same implementation but using name param: \n");
        System.out.println(studentRepository.getStudentByEmailNativeParam("alec.osinski@yahoo.com"));

    }

    @Test
    @Order(5)
    void testUpdateStudent() {
        Integer ousmane = studentRepository.updateStudent(
                "Ousmane",
                "alec.osinski@yahoo.com");
        System.out.println(ousmane);
    }

    @Test
    @Order(6)
    void testCourseMaterial() {
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            Course course = new Course(faker.programmingLanguage().name(), 5);
            CourseMaterial courseMaterial = CourseMaterial.builder()
                    .url(faker.internet().avatar())
                    .course(course)
                    .build();
            cmRepository.save(courseMaterial);
        }
    }

    @Test
    @Order(7)
    void testPrintCourseMaterial() {
        List<CourseMaterial> all = cmRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    @Order(8)
    void testFindAllPagination() {
        Sort sort = Sort.by("name").descending();
        Pageable pageable = PageRequest.of(1, 4, sort);
        Pageable twoRecords = PageRequest.of(1, 3);
        List<Student> students = studentRepository.findAll(pageable).getContent();
        List<CourseMaterial> courseMaterials = cmRepository.findAll(twoRecords).getContent();

        System.out.println("Page Size: " + pageable.getPageSize());
        System.out.println("Page Number: " + pageable.getPageNumber());

        students.forEach(System.out::println);
        System.out.println("course materials:\n" + courseMaterials);

    }

    @Test
    @Order(9)
    void printByTitleContaining() {
        Pageable pageable =
                PageRequest.of(0, 4, Sort.by("title").ascending());
        List<Course> courses = courseRepository.findByTitleContaining("l", pageable).getContent();
        for (Course c : courses) {
            System.out.println(c);
        }

    }

    @Test
    @Order(10)
    void saveCourses() {
        Teacher teacher = Teacher.builder()
                .firstName("Francis")
                .lastName("Dauda")
                .build();

//        Course course = Course.builder()
//                .title("PYTHON")
//                .credit(7)
//                .teacher(teacher)


    }
}
