package logic;

public class Worker {
    private final String id;
    private final boolean clockedIn;

    public Worker(String cardId, boolean clockedIn) {
        this.id = cardId;
        this.clockedIn = clockedIn;
    }

    public String getId() {
        return id;
    }

    public boolean isClockedIn() {
        return clockedIn;
    }

}