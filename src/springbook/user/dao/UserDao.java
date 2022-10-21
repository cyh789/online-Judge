package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException{
        //DB연결을 위한 커넥션 가져오기
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook","spring","book");

        //SQL을 담을 PreparedStatement 만들기
        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) value(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        //Statement 실행
        ps.executeUpdate();

        //리소스 닫아주기
        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException{
        //DB연결을 위한 커넥션 가져오기
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook","spring","book");

        //SQL을 담을 PreparedStatement 만들기
        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        //실행결과를 ResultSet에 담기
        ResultSet rs = ps.executeQuery();
        rs.next();

        //정보를 User객체에 담기
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        //리소스 닫아주기
        rs.close();
        ps.close();
        c.close();

        return user;
    }
}