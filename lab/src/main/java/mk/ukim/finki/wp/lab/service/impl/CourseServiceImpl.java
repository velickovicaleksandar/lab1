package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;

    public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return this.courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student s = this.studentService.listAll().stream().filter(student -> student.getUsername().equals(username)).findFirst().get();
        Course c = this.courseRepository.findById(courseId);
        return this.courseRepository.addStudentToCourse(s,c);
    }

    @Override
    public List<Course> listAll() {
        return this.courseRepository.findAllCourses();
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findById(id);
    }
}
