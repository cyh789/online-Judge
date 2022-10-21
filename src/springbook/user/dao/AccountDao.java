package springbook.user.dao;

public class AccountDao {
    private ConnectionMaker cm;
    public AccountDao(ConnectionMaker connectionMaker) {
        this.cm = connectionMaker;
    }
}
