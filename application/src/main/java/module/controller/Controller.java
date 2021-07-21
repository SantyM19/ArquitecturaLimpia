package module.controller;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicemodule.format.GameFormat;
import servicemodule.service.GameService;

import java.util.List;

@RestController
@RequestMapping("/games")

public class Controller {
    @Autowired
    GameService gameService;

    @PostMapping("/create")
    public ResponseEntity<GameFormat> create(@RequestBody GameFormat gameFormat){
        return new ResponseEntity<>(gameService.creategame(gameFormat), HttpStatus.CREATED);
    }

    @GetMapping()
    public  ResponseEntity<List<GameFormat>>findAll(){
        return new ResponseEntity<>(gameService.getAll(),HttpStatus.OK);
    }
}
