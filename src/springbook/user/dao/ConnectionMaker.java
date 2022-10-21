package springbook.user.dao;

import java.sql.SQLException;

public interface ConnectionMaker<E> {

    public E makeConnection() throws ClassNotFoundException, SQLException;
}
