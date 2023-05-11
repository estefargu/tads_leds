package co.edu.umanizales.tads_leds.service;

import co.edu.umanizales.tads_leds.model.Led;
import co.edu.umanizales.tads_leds.model.ListDE;
import co.edu.umanizales.tads_leds.model.NodeDE;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class ListDEService {
    private ListDE leds;

    public ListDEService() {
        leds = new ListDE();
    }

    public List<Led> getLedList() {
        List<Led> ledList = new ArrayList<>();
        NodeDE temp = leds.getHead();
        while (temp != null) {
            ledList.add(temp.getData());
            temp = temp.getNext();
        }
        return ledList;
    }
}
