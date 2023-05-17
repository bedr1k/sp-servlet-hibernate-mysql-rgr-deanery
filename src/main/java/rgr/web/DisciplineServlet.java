package rgr.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import rgr.dao.impl.DisciplineDaoImpl;
import rgr.entity.Discipline;
import rgr.entity.Exam;

@WebServlet("/discipline")
public class DisciplineServlet extends AbstractServlet<Discipline> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		dao = new DisciplineDaoImpl();
	}
	@Override
	protected void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("discipline-form.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Discipline discipline = new Discipline(name);
		dao.save(discipline);
		response.sendRedirect("discipline");
	}
	@Override
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Discipline discipline = dao.read(id);
		dao.delete(discipline);
		response.sendRedirect("discipline");	
	}
	@Override
	protected void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Discipline existingDiscipline = dao.read(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("discipline-form.jsp");
		request.setAttribute("discipline", existingDiscipline);
		dispatcher.forward(request, response);
	}
	@Override
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		Discipline discipline = new Discipline(id, name);
		dao.edit(discipline);
		response.sendRedirect("discipline");
	}
	@Override
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Discipline> list = dao.read();
		Map<Discipline, Double> map = getMapAvgGrade(list);
		request.setAttribute("listDisciplines", list);
		request.setAttribute("mapGrades", map);
		RequestDispatcher dispatcher = request.getRequestDispatcher("discipline-list.jsp");
		dispatcher.forward(request, response);	
	}
	
 	private Map<Discipline, Double> getMapAvgGrade(List<Discipline> list) {
		Map<Discipline, Double> map = new HashMap<Discipline, Double>();
		for (Discipline discipline: list) {
			double avgGrade = 0;
			if (discipline.getExams().size() != 0) {
				for (Exam exam: discipline.getExams()) {
					avgGrade += exam.getGrade();
				}
				avgGrade = Math.round(avgGrade / discipline.getExams().size());
				map.put(discipline, avgGrade);
			}
		}
		return map;
	}
}
