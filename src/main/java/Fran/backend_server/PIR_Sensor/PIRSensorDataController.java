package Fran.backend_server.PIR_Sensor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/PIRgraph")
public class PIRSensorDataController {
    private final PIR_Sensor_Data_Collection_Repository _repo;
    public PIRSensorDataController(PIR_Sensor_Data_Collection_Repository r) {
        _repo = r;
    }

    @GetMapping("/{sensorLocation}")
    public List<PIR_Sensor_Data_Point> find_By_Location(
            @PathVariable String sensorLocation,
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {

        System.out.println("Request received for: " + sensorLocation);
        System.out.println("Time range: " + start + " to " + end);

        List<PIR_Sensor_Data_Point> result = _repo.getData_range(sensorLocation, start, end);
        System.out.println("Found " + result.size() + " records");

        return result;
    }

    @GetMapping("/test-data")
    public List<PIR_Sensor_Data_Point> getAllTestData() {
        return _repo.getAllData_points();
    }
}