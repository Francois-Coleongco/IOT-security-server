package Fran.backend_server.PIR_Sensor;

import java.time.Instant;

import jakarta.persistence.*;

// the _time is just the time PIR initially sensed motion
@Entity
@Table(name = "pir_sensor_data")
public class PIRSensorDataPoint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String location;

	@Column(columnDefinition = "TIMESTAMPTZ", nullable = false)
	private Instant timestamp;

	public void setLocation(String location) {
		this.location = location;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
}
