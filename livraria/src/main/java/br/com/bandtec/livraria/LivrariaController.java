package br.com.bandtec.livraria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivrariaController {

    @GetMapping
    public String getHome(){
        return "Funcionou";
    }
}
