package co.edu.umanizales.tads_leds.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Led {
    private int id;
    private boolean state;
    private LocalTime dateOn;
    private LocalTime dateOff;

    public Led (int id) {
        this.id = id;
        this.state = false;
        this.dateOn = null;
        this.dateOff =null;
    }
}
