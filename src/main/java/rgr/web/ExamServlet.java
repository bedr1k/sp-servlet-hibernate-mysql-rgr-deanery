package rgr.web;

import java.io.IOException;
import java.util.List;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rgr.dao.Dao;
import rgr.dao.impl.StudentDaoImpl;
import rgr.dao.impl.DisciplineDaoImpl;
import rgr.dao.impl.ExamDaoImpl;
import rgr.entity.Discipline;
import rgr.entity.Exam;
import rgr.entity.Student;

@WebServlet("/exam")
public class ExamServlet extends AbstractServlet<Exam> {

	private static final long serialVersionUID = 1L;
	private Dao<Student> daoStudent = new StudentDaoImpl();
	private Dao<Discipline> daoDiscipline = new DisciplineDaoImpl();
	
	@Override
	public void init() {
		dao = new ExamDaoImpl();
	}

	@Override
	protected void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("exam-form.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		int grade = Integer.parseInt(request.getParameter("grade"));
		String examDayString = request.getParameter("examDay");
		Date examDay = null;
		try {
			examDay = format.parse(examDayString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long disciplineId = Long.parseLong(request.getParameter("disciplineId"));
		long studentId = Long.parseLong(request.getParameter("studentId"));
		Discipline discipline = daoDiscipline.read(disciplineId);
		Student student = daoStudent.read(studentId);
		Exam exam = new Exam(grade, examDay, discipline, student);
		dao.save(exam);
		response.sendRedirect("exam");
	}

	@Override
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Exam exam = dao.read(id);
		dao.delete(exam);
		response.sendRedirect("exam");
	}

	@Override
	protected void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Exam existingExam = dao.read(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("exam-form.jsp");
		request.setAttribute("exam", existingExam);
		dispatcher.forward(request, response);	
	}

	@Override
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
		long id = Long.parseLong(request.getParameter("id"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		String examDayString = request.getParameter("examDay");
		Date examDay = null;
		try {
			examDay = format.parse(examDayString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long disciplineId = Long.parseLong(request.getParameter("disciplineId"));
		long studentId = Long.parseLong(request.getParameter("studentId"));
		Discipline discipline = daoDiscipline.read(disciplineId);
		Student student = daoStudent.read(studentId);
		Exam exam = new Exam(id, grade, examDay, discipline, student);
		dao.edit(exam);
		response.sendRedirect("exam");
	}

	@Override
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Exam> list = dao.read();
		request.setAttribute("listExams", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("exam-list.jsp");
		dispatcher.forward(request, response);
	}

}
