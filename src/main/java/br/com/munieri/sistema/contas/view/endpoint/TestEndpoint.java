package br.com.munieri.sistema.contas.view.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestEndpoint {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity get() {

        return ResponseEntity.ok("teste!!!");
    }
}
