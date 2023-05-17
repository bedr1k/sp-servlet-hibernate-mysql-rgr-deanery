package rgr.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import rgr.dao.Dao;
import rgr.dao.impl.StudentDaoImpl;
import rgr.dao.impl.StudentsGroupDaoImpl;
import rgr.entity.Exam;
import rgr.entity.Student;
import rgr.entity.StudentsGroup;

@WebServlet("/student")
public class StudentServlet extends AbstractServlet<Student> {


	private static final long serialVersionUID = 1L;
	private Dao<StudentsGroup> daoGroup = new StudentsGroupDaoImpl();
	
	@Override
	public void init() {
		dao = new StudentDaoImpl();
	}
	@Override
	protected void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String secondName = request.getParameter("secondName");
		String patronymic = request.getParameter("patronymic");
		long groupId = Long.parseLong(request.getParameter("groupId"));
		StudentsGroup group = daoGroup.read(groupId);
		Student student = new Student(firstName, secondName, patronymic, group);
		dao.save(student);
		response.sendRedirect("student");
	}
	@Override
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Student student = dao.read(id);
		dao.delete(student);
		response.sendRedirect("student");
	}
	@Override
	protected void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Student existingStudent = dao.read(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);	
	}
	@Override
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String secondName = request.getParameter("secondName");
		String patronymic = request.getParameter("patronymic");
		long groupId = Long.parseLong(request.getParameter("groupId"));
		StudentsGroup group = daoGroup.read(groupId);
		Student student = new Student(id, firstName, secondName, patronymic, group);
		dao.edit(student);
		response.sendRedirect("student");
	}
	@Override
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> list = dao.read();
		Map<Student, Double> mapGrade = getMapAvgGrade(list);
		request.setAttribute("listStudents", list);
		request.setAttribute("mapGrades", mapGrade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);
	}
	private Map<Student, Double> getMapAvgGrade(List<Student> list) {
		Map<Student, Double> map = new HashMap<Student, Double>();
		for (Student student: list) {
			double avgGrade = 0;
			if (student.getExams().size() != 0) {
				for (Exam exam: student.getExams()) {
					avgGrade += exam.getGrade();
				}
				avgGrade = Math.round(avgGrade / student.getExams().size());
				map.put(student, avgGrade);
			}
		}
		return map;
	}
}
