package Fran.backend_server.PIR_Sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/PIRgraph")
public class PIRSensorDataController {
    @Autowired
    private PirService pirService;

    @GetMapping("/{sensorLocation}")
    public List<PIRSensorDataPoint> find_By_Location(
            @PathVariable String sensorLocation,
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant end) {

        System.out.println("Request received for: " + sensorLocation);
        System.out.println("Time range: " + start + " to " + end);

        List<PIRSensorDataPoint> result = pirService.getPirPointsByRange(start, end);
        
        System.out.println("Found " + result.size() + " records");

        return result;
    }

}