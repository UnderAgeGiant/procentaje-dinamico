package cl.prueba.tenpo.procentaje_dinamico.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PorcentajeDinamicoController {
    
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }
}
