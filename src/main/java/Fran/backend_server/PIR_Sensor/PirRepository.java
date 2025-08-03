package Fran.backend_server.PIR_Sensor;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PirRepository extends JpaRepository<PIRSensorDataPoint, Long> {
    Optional<PIRSensorDataPoint> findPointByTimestamp(Instant ts);
    List<PIRSensorDataPoint> findByTimestampBetween(Instant start, Instant end);
}