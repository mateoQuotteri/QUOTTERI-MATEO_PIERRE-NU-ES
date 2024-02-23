package com.backend.dao.impl;

import com.backend.dao.IDao;
import com.backend.dbconnection.H2Connection;
import com.backend.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo>  {
    private final Logger LOGGER = Logger.getLogger(String.valueOf(OdontologoDaoH2.class));


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        String insert ;
        Connection connection = null;
        Odontologo odontologoObtenido = null;

        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);


            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS(NOMBRE, APELLIDO, NUMERO_MATRICULA) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setInt(3, odontologo.getNumeroDeMatricula());
            preparedStatement.execute();

            connection.commit();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                odontologoObtenido = new Odontologo(resultSet.getInt(1), odontologo.getNombre(), odontologo.getApellido(), odontologo.getNumeroDeMatricula());
            }


            LOGGER.info("Odontologo almacenado: " + odontologoObtenido);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Tuvimos un problema");
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (Exception ex) {
                        LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
                    }
                }
            }
        }

        return odontologoObtenido;
    }

    @Override
    public List<Odontologo> listarTodos() {
    Connection connection = null;
    List<Odontologo> todosLosOdontologos = new ArrayList<>();

        try{
         connection = H2Connection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Odontologo odontologo = crearObjetoOdontologo(resultSet);
            todosLosOdontologos.add(odontologo);
        }

        LOGGER.info("Listado de odontologos obtenido: " + todosLosOdontologos);

    } catch (Exception e) {
        LOGGER.error(e.getMessage());
        e.printStackTrace();

    } finally {
        try {
            connection.close();
        } catch (Exception ex) {
            LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
            ex.printStackTrace();
        }
    }

        return todosLosOdontologos ;
}



private Odontologo crearObjetoOdontologo(ResultSet resultSet) throws SQLException {

    Odontologo odontologoADevolver = new Odontologo(resultSet.getInt("id"),
            resultSet.getString("nombre"),
            resultSet.getString("apellido"),
            resultSet.getInt("numero_matricula"));
    return odontologoADevolver;

}
}
