package Fran.backend_server.PIR_Sensor;
import java.time.LocalDateTime;

// the _time is just the time PIR initially sensed motion
public record PIR_Sensor_Data_Point (String _sensor_location, LocalDateTime _time){

}