package cl.prueba.tenpo.porcentaje_dinamico.application.controller;

import org.springframework.web.bind.annotation.RestController;

import cl.prueba.tenpo.porcentaje_dinamico.application.service.ProcentajeDinamicoService;
import cl.prueba.tenpo.porcentaje_dinamico.domain.PorcentajeDinamicoRequestBody;
import cl.prueba.tenpo.porcentaje_dinamico.domain.PorcentajeDinamicoResponseBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
public class PorcentajeDinamicoController {
    
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping("/")
    public ResponseEntity<PorcentajeDinamicoResponseBody> PorcentajeDinamico(@RequestBody PorcentajeDinamicoRequestBody body ){
        ProcentajeDinamicoService service = new ProcentajeDinamicoService();
        PorcentajeDinamicoResponseBody response = service.resolvePorcentajeDinamico(body);
        return ResponseEntity.status(response.getCode()).body(response);
    }

}
