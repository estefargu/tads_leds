package co.edu.umanizales.tads_leds.service;

import co.edu.umanizales.tads_leds.model.ListDE;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ListDEService {
    private ListDE leds;
}
