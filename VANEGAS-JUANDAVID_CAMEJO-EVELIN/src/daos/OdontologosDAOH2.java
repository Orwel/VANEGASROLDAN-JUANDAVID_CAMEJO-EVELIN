package daos;

import entidades.Odontologos;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class OdontologosDAOH2 implements IDao<Odontologos> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/odontologosbd";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    private static final Logger logger = LogManager.getLogger(OdontologosDAOH2.class);

    @Override
    public Odontologos guardar(Odontologos odontologos) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO odontologosregistrados (matricula, nombre, apellido) VALUES (?,?,?)");

            preparedStatement.setInt(1, odontologos.getMatricula());
            preparedStatement.setString(2, odontologos.getNombre());
            preparedStatement.setString(3, odontologos.getApellido());

            preparedStatement.executeUpdate();
            logger.info("Se ha guardado un nuevo odontólogo correctamente.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            logger.error("Error al intentar guardar un odontólogo en la base de datos.");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return odontologos;
    }

    @Override
    public List<Odontologos> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologos> odontologosList = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologosregistrados");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int matricula = result.getInt("matricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                Odontologos odontologos = new Odontologos(matricula, nombre, apellido);
                odontologosList.add(odontologos);
            }
            logger.info("Lista de odontólogos recuperada exitosamente.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            logger.error("Error al intentar buscar todos los odontólogos en la base de datos.");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return odontologosList;
    }
}

