package logic.vehicle;

import logic.Service;
import logic.Vehicle;

import java.time.LocalDateTime;

public class HistoryEntry {
    private final String serviceId;
    private final LocalDateTime date;
    private final String status;

    public HistoryEntry(String serviceId, String date, String status) {
        this.serviceId = serviceId;
        this.date = LocalDateTime.parse(date);
        this.status = status;
    }

    public String getServiceId() {
        return serviceId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
