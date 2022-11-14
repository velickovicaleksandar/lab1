package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "StudentEnrollmentSummaryServlet", urlPatterns = "/StudentEnrollmentSummary")
public class StudentEnrollmentSummaryServlet extends HttpServlet {
    private final CourseService courseService;
    private final SpringTemplateEngine springTemplateEngine;
    private final StudentService studentService;

    public StudentEnrollmentSummaryServlet(CourseService courseService, SpringTemplateEngine springTemplateEngine, StudentService studentService) {
        this.courseService = courseService;
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = (Long) request.getSession().getAttribute("courseId");
        Course course = this.courseService.findById(id);
        WebContext context = new WebContext(request,response,request.getServletContext());
        context.setVariable("course",course);
        this.springTemplateEngine.process("studentsInCourse.html",context,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("student");
      Optional<Student> s= this.studentService.searchByNameOrSurname(username);
      Long courseId= (Long) request.getSession().getAttribute("courseId");
      this.courseService.addStudentInCourse(username,courseId);

    }
}
