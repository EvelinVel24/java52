package servlet;

import dao.EmpleadoDao;
import dao.EmpleadoDaoImpl;
import modelo.Empleado;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProcesaEmpleado")
public class ProcesaEmpleado extends HttpServlet {
    @Resource(name = "jdbc/miBaseDatos") // Define tu recurso JDBC
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl(dataSource);
        List<Empleado> empleados = empleadoDao.obtieneEmpleado();

        request.setAttribute("empleados", empleados);
        request.getRequestDispatcher("empleado.jsp").forward(request, response);
    }
}
