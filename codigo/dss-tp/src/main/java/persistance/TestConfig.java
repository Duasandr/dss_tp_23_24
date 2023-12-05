package persistance;

public class TestConfig extends Config {
    public TestConfig() {
        super(
            "jdbc:mariadb://localhost:3306/",
            "EsIdealTest",
            "test",
            "your_password"
        );
    }
}
