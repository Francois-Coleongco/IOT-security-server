package Fran.backend_server.PIR_Sensor;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PIR_Sensor_Data_Collection_Repository {
    private final List<PIR_Sensor_Data_Point> data_points = new ArrayList<>();

    public PIR_Sensor_Data_Collection_Repository() {}

    public List<PIR_Sensor_Data_Point> getAllData_points() {
        return data_points;
    }

    public Optional<PIR_Sensor_Data_Point> getData_point(String sensor_location) {
        return data_points.stream().filter(dp -> dp._sensor_location().equals(sensor_location)).findFirst();
    }
    public List<PIR_Sensor_Data_Point> getData_range(String sensor_location, LocalDateTime start, LocalDateTime end) {
        return data_points.stream()
                .filter(dp -> dp._sensor_location().equals(sensor_location))
                .filter(dp -> !dp._time().isBefore(start) && !dp._time().isAfter(end)) // Inclusive range
                .collect(Collectors.toList());
    }

    @PostConstruct
    private void init() {

        PIR_Sensor_Data_Point a = new PIR_Sensor_Data_Point("livingRoom", LocalDateTime.now());
        PIR_Sensor_Data_Point b = new PIR_Sensor_Data_Point("backyard", LocalDateTime.now());
        PIR_Sensor_Data_Point c = new PIR_Sensor_Data_Point("myRoom", LocalDateTime.now());

        this.data_points.add(a);
        this.data_points.add(b);
        this.data_points.add(c);

    }
}
