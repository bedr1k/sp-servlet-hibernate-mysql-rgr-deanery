package rgr.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rgr.dao.Dao;

public abstract class AbstractServlet<T> extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected Dao<T> dao;
	
	public abstract void init();
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
		switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insert(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				update(request, response);
				break;
			default:
				list(request, response);
				break;
		}
	}
	protected abstract void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	protected abstract void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	protected abstract void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	protected abstract void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	protected abstract void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	protected abstract void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
}
