package springbook.user.dao;

import springbook.user.domain.CustomConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker<E> implements ConnectionMaker {

    @Override
    public E getConnection() throws ClassNotFoundException, SQLException {
        Connection c = null;
        return (E) c;
    }
}
