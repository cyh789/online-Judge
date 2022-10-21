package springbook.user;

import springbook.user.dao.*;

public class DaoFactory {

    public static UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    public static AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public static MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    private static ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }


}
