package springbook.user.dao;

public class MessageDao {

    private ConnectionMaker cm;

    public MessageDao(ConnectionMaker connectionMaker) {
        cm = connectionMaker;
    }
}
