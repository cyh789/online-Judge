package springbook.user;

import java.sql.SQLException;

//import springbook.user.dao.DUserDao;
import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = DaoFactory.userDao();

        //저장할 정보를 User 객체에 set
        User user = new User();
        user.setId("superman2");
        user.setName("슈퍼맨");
        user.setPassword("batman1234");

        //셋팅한 User 객체를 add 인자로 넘겨 메소드 호출
        dao.add(user);

        System.out.println(user.getId() + "등록성공");

        //get메소드 호출하여 정상적으로 DB 데이터를 가져오는지 확인
        User user2 = dao.get("superman2");
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");

    }
}