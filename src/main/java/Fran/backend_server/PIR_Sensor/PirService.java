package Fran.backend_server.PIR_Sensor;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PirService {
    @Autowired
    private PirRepository pr;

    public PIRSensorDataPoint addPirPoint(String location, Instant ts) {
        if (ts.isAfter(Instant.now())) {
            throw new IllegalArgumentException("PIR Point <PROVIDED> has a timestamp from the future??? That doesn't make sense.");
        }

        PIRSensorDataPoint psdp = new PIRSensorDataPoint();
        psdp.setLocation(location);
        psdp.setTimestamp(ts);

        return pr.save(psdp);
    }

    public PIRSensorDataPoint fetchPirPointByTimestamp(Instant ts) {
        if (ts.isAfter(Instant.now())) {
            throw new IllegalArgumentException("PIR Point <REQUESTED> has a timestamp from the future??? That doesn't make sense.");
        }

        return pr.findPointByTimestamp(ts).orElse(null);
    }

    public List<PIRSensorDataPoint> getPirPointsByRange(Instant start, Instant end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("PIR Range provided has end Instant before start Instant");
        }
        return pr.findByTimestampBetween(start, end);
    }

}