import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class FirstServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("First Servlet: doGet");
        System.out.println("First Servlet: " + request.getAttribute("test"));
        if (request.getParameter("COMMAND") != null) {
            if (request.getParameter("COMMAND").equals("UPDATE_PAGE")) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("person-update.jsp");
                request.setAttribute("person", new Person(Integer.parseInt(request.getParameter("id")), request.getParameter("name")));
                requestDispatcher.forward(request, response);
                response.sendRedirect("person-update.jsp");
            } else if (request.getParameter("COMMAND").equals("UPDATE")) {
                Person person = new Person(Integer.parseInt(request.getParameter("id")), request.getParameter("name"));
                DBUtil.update(person);
                response.sendRedirect("first");
            } else if (request.getParameter("COMMAND").equals("DELETE")) {
                int id = Integer.parseInt(request.getParameter("id"));
                DBUtil.delete(id);
                response.sendRedirect("first");
            } else {
                List<Person> persons = null;
                try {
                    persons = DBUtil.getAll();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("persons", persons);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("person-list.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            List<Person> persons = null;
            try {
                persons = DBUtil.getAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("persons", persons);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("person-list.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("First Servlet: doPost");
        Person person = new Person(Integer.parseInt(request.getParameter("id")), request.getParameter("name"));
        try {
            DBUtil.create(person);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("first");
    }

}