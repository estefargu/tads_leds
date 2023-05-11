package co.edu.umanizales.tads_leds.controller;

import co.edu.umanizales.tads_leds.controller.dto.LedDTO;
import co.edu.umanizales.tads_leds.controller.dto.ResponseDTO;
import co.edu.umanizales.tads_leds.model.Led;
import co.edu.umanizales.tads_leds.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/listde")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getPets() {
        List<Led> ledList = listDEService.getLedList();
        return new ResponseEntity<>(new ResponseDTO(200, ledList, null), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ResponseDTO> addToStart(@RequestBody LedDTO ledDTO){
        listDEService.getLeds().addToStart(new Led(ledDTO.getId()));
        return new ResponseEntity<>(new ResponseDTO(
                200,"Se ha adicionado el led al inicio de la lista",
                null), HttpStatus.OK);
    }

    @PostMapping(path= "/addtoend")
    public ResponseEntity<ResponseDTO> addToEnd(@RequestBody LedDTO ledDTO){
        listDEService.getLeds().addToEnd(new Led(ledDTO.getId()));
        return new ResponseEntity<>(new ResponseDTO(
                200,"Se ha adicionado el led al final de la lista",
                null), HttpStatus.OK);
    }

    @GetMapping(path = "/restartled")
    public ResponseEntity<ResponseDTO> getRestartLed() {
        listDEService.getLeds().getRestartLed();
        return new ResponseEntity<>(new ResponseDTO(200, "Se han reiniciado los leds a su estado apagado",
                null), HttpStatus.OK);
    }

    @GetMapping(path = "/turnonledby1secondandturnonextremes")
    public ResponseEntity<ResponseDTO> getTurnOnLedBy1SecondAndTurnOnExtremes() {
        try {
            listDEService.getLeds().getTurnOnLedBy1SecondAndTurnOnExtremes();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(new ResponseDTO(200, "Se han encendido los extremos de la lista",
                null), HttpStatus.OK);
    }

}
