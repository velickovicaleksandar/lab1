package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.DataHolder.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Repository
public class CourseRepository {
    List<Course> courseList;

    public CourseRepository(List<Course> courseList) {
        this.courseList = DataHolder.courseList;
    }

    public List<Course> findAllCourses() {
        return courseList;
    }



   public Course findById(Long courseId) {
        return (Course) courseList.stream().filter(course -> course.getCourseId() == courseId);
    }



    public List<Student> findAllStudentsByCourse(Long courseId) {
        return courseList.stream().filter(course -> course.getCourseId() == courseId).findFirst().get().getStudents();

    }



    public Course addStudentToCourse(Student student, Course course) {
        List<Student> students = course.getStudents();
        students.add(student);
        course.setStudents(students);
        return course;
    }




}
