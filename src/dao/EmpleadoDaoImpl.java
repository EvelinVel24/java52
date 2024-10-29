package dao;

import modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class EmpleadoDaoImpl implements EmpleadoDao {
    private DataSource dataSource;

    public EmpleadoDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Empleado> obtieneEmpleado() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM EMPLEADO";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("ID"));
                empleado.setNombre(rs.getString("NOMBRE"));
                empleado.setApellido(rs.getString("APELLIDO"));
                empleado.setDepartamento(rs.getString("DEPARTAMENTO"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }
}
