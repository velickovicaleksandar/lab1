package mk.ukim.finki.wp.lab.DataHolder;

import lombok.Getter;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Student> studentList = new ArrayList<>();
    public static List<Course> courseList = new ArrayList<>();


    @PostConstruct
    public void init() {
        studentList.add(new Student("markom","marko123","Marko", "Markovski"));
        studentList.add(new Student("nikolan","nikola123","Nikola", "Nikolovski"));
        studentList.add(new Student("stefant","stefan123","Stefan", "Trajkovski"));
        studentList.add(new Student("gjorgjis","pass123","Gjorgji", "Stojanovski"));
        studentList.add(new Student("kristijans","pass123","Kristijan", "Stojkovski"));
        courseList.add(new Course(122123L,"SP","Programming", Arrays.asList(studentList.get(0),studentList.get(1))));
        courseList.add(new Course(326123L,"VIS","Statistics", Arrays.asList(studentList.get(2),studentList.get(3))));
        courseList.add(new Course(133195L,"WP","Web Programming", Arrays.asList(studentList.get(4),studentList.get(1))));
        courseList.add(new Course(3231783L,"CALC","Calculus", Arrays.asList(studentList.get(2),studentList.get(4))));
        courseList.add(new Course(223123L,"OS","Operating Sys", Arrays.asList(studentList.get(3),studentList.get(0))));


    }
}
