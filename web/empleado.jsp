<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Empleados</title>
</head>
<body>
    <h1>Lista de Empleados</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Departamento</th>
        </tr>
        <%
            List<modelo.Empleado> empleados = (List<modelo.Empleado>) request.getAttribute("empleados");
            for (modelo.Empleado empleado : empleados) {
        %>
        <tr>
            <td><%= empleado.getId() %></td>
            <td><%= empleado.getNombre() %></td>
            <td><%= empleado.getApellido() %></td>
            <td><%= empleado.getDepartamento() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
