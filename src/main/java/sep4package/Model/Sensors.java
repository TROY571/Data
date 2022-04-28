package sep4package.Model;

import org.hibernate.annotations.GenericGenerator;
import sep4package.Model.CO2.CO2Sensor;
import sep4package.Model.Humidity.HumiditySensor;
import sep4package.Model.Temperature.TemperatureSensor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Sensors")
@Table(name = "sensors_data")
public class Sensors {
    @Id
    @Column(updatable = false)
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sensors_sequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
    private int SensorId;

   // @OneToOne
    //@JoinTable(name = "TemperatureId")
    private Long TemperatureId;

   // @OneToOne
    //@JoinColumn(name = "HumidityId")
    private Long HumidityId;

   // @OneToOne
    //@JoinColumn(name = "CO2Id")
    private Long CO2Id;

    @Column
    private boolean IsLightOn;
    @Column
    private boolean IsWindowOpen;

    @Column
    private Timestamp Time;

    public Sensors(int sensorId, Long temperatureId, Long humidityId, Long CO2Id, Timestamp time) {
        SensorId = sensorId;
        TemperatureId = temperatureId;
        HumidityId = humidityId;
        this.CO2Id = CO2Id;
        IsLightOn = false;
        IsWindowOpen = false;
        Time = time;
    }

    public Sensors() {
    }

    public int getSensorId() {
        return SensorId;
    }

    public void setSensorId(int sensorId) {
        SensorId = sensorId;
    }

    public Long getTemperatureId() {
        return TemperatureId;
    }

    public void setTemperatureId(Long temperatureId) {
        TemperatureId = temperatureId;
    }

    public Long getHumidityId() {
        return HumidityId;
    }

    public void setHumidityId(Long humidityId) {
        HumidityId = humidityId;
    }

    public Long getCO2Id() {
        return CO2Id;
    }

    public void setCO2Id(Long CO2Id) {
        this.CO2Id = CO2Id;
    }

    public boolean isLightOn() {
        return IsLightOn;
    }

    public void setLightOn(boolean lightOn) {
        IsLightOn = lightOn;
    }

    public boolean isWindowOpen() {
        return IsWindowOpen;
    }

    public void setWindowOpen(boolean windowOpen) {
        IsWindowOpen = windowOpen;
    }

    public Timestamp getTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public void setTime(Timestamp time) {
        Time = time;
    }
}
