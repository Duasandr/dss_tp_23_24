package persistance;

public class Config {
    public final String DRIVER;
    public final String NAME;
    public final String USER;
    public final String PASSWORD;

    public Config(String driver, String name, String user, String password) {
        this.DRIVER = driver;
        this.NAME = name;
        this.USER = user;
        this.PASSWORD = password;
    }
}
