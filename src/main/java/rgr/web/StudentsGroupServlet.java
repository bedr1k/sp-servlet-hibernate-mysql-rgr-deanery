package rgr.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rgr.dao.impl.StudentsGroupDaoImpl;
import rgr.entity.StudentsGroup;

@WebServlet("/group")
public class StudentsGroupServlet extends AbstractServlet<StudentsGroup> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		dao = new StudentsGroupDaoImpl();
	}
	@Override
	protected void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentsgroup-form.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int course = Integer.parseInt(request.getParameter("course"));
		StudentsGroup group = new StudentsGroup(name, course);
		dao.save(group);
		response.sendRedirect("group");
	}
	@Override
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		StudentsGroup group = dao.read(id);
		dao.delete(group);
		response.sendRedirect("group");
	}
	@Override
	protected void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		StudentsGroup existingGroup = dao.read(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentsgroup-form.jsp");
		request.setAttribute("group", existingGroup);
		dispatcher.forward(request, response);
	}
	@Override
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		int course = Integer.parseInt(request.getParameter("course"));

		StudentsGroup group = new StudentsGroup(id, name, course);
		dao.edit(group);
		response.sendRedirect("group");
	}
	@Override
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<StudentsGroup> list = dao.read();
		request.setAttribute("listGroups", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentsgroup-list.jsp");
		dispatcher.forward(request, response);
	}
}
