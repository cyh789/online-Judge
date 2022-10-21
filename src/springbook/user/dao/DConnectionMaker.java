package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DConnectionMaker<E> implements ConnectionMaker {

    @Override
    public E makeConnection() throws ClassNotFoundException, SQLException {
        Connection c = null;
        return (E) c;
    }
}
