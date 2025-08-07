package Fran.backend_server.PIR_Sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/PIRgraph")
public class PIRSensorDataController {
	@Autowired
	private PirService pirService;

	@GetMapping("/{sensorLocation}")
	public List<PIRSensorDataPoint> findByLocation(
			@PathVariable String sensorLocation,
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant start,
			@RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant end) {

		System.out.println("Request received for: " + sensorLocation);
		System.out.println("Time range: " + start + " to " + end);

		List<PIRSensorDataPoint> result = pirService.getPirPointsByRange(start, end);

		System.out.println("Found " + result.size() + " records");

		return result;
	}

	@PostMapping("/{sensorLocation}")
	public ResponseEntity<String> postByLocation(@RequestBody String location, @RequestBody Instant ts) {
		try {
			pirService.addPirPoint(location, ts);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("could not add PIR point. invalid data.");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Resource found.");
	}

}
