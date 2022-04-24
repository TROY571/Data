package Model.Humidity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Humidity")
@Table(name = "humidity")
public class HumiditySensor
{
    @Id
    @Column(updatable = false)
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
        name = "sequence-generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "humidity_sequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
    )
    private Long HumidityId;
    @Column
    private double Humidity;
    @Column
    private Timestamp Time;

    public HumiditySensor(double Humidity,Timestamp Time)
    {
        this.Humidity = Humidity;
        this.Time = Time;
    }

    public HumiditySensor() {
    }

    public Long getHumidityId()
    {
        return HumidityId;
    }

    public void setHumidityId(Long humidityId)
    {
        HumidityId = humidityId;
    }

    public double getHumidity()
    {
        return Humidity;
    }

    public void setHumidity(double humidity)
    {
        Humidity = humidity;
    }

    public Timestamp getTime()
    {
        return Time;
    }

    public void setTime(Timestamp time)
    {
        Time = time;
    }
}