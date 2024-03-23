package logic;

import java.time.LocalDateTime;

public class Quote {
       private Vehicle vehicle;
        private Service service;
        private LocalDateTime estimatedCompletionDate;

        public Quote(Vehicle vehicle, Service service, LocalDateTime estimatedCompletionDate) {
            this.vehicle = vehicle;
            this.service = service;
            this.estimatedCompletionDate = estimatedCompletionDate;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public Service getService() {
            return service;
        }

        public LocalDateTime getEstimatedCompletionDate() {
            return estimatedCompletionDate;
        }

        @Override
        public String toString() {
            return "Quote{" +
                    "vehicle=" + vehicle +
                    ", service=" + service +
                    ", estimatedCompletionDate=" + estimatedCompletionDate +
                    '}';
        }
}
