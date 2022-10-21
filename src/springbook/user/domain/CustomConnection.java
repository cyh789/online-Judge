package springbook.user.domain;

import java.sql.PreparedStatement;
import java.util.LinkedList;

public class CustomConnection {
    private LinkedList<User> list;
    private String name;
    private String query;

    public CustomConnection() {
        list = new LinkedList<>();
    }

    public CustomConnection(String name) {
        list = new LinkedList<>();
        this.name = name;
    }

    public LinkedList<User> getList() {
        return list;
    }

    public void setList(LinkedList<User> list) {
        this.list = list;
    }

    public String setQuery(String query) {
        this.query = query;
        return this.query;
    }
}
