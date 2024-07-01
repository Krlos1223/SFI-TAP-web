package sfitap;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("registro.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String cedula = request.getParameter("cedula");
        String fechaNacimiento = request.getParameter("fecha_nacimiento");
        String rol = request.getParameter("rol");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Conexion a base de datos
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Cargar el driver JDBC (esto puede variar según la base de datos que estés usando)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar a la base de datos
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_sfi_tap", "capiedrahita1", "C@ps*7414");

            // Preparar la sentencia SQL
            String sql = "INSERT INTO usuarios (nombre, apellido, cedula, fecha_de_nacimiento, rol, nombre_de_usuario, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            // Establecer los valores de los parámetros
            pstmt.setString(1, nombres);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, cedula);
            pstmt.setString(4, fechaNacimiento);
            pstmt.setString(5, rol);
            pstmt.setString(6, username);
            pstmt.setString(7, password);

            // Ejecutar la sentencia
            pstmt.executeUpdate();

            request.setAttribute("mensaje", "Registro exitoso");
        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("mensaje", "Error en el registro: " + e.getMessage());
        } finally {
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
        }

        request.getRequestDispatcher("registro_exitoso.jsp").forward(request, response);
    }
}
