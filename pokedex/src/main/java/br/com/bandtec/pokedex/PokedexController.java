package br.com.bandtec.pokedex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokedexController {

    @GetMapping
    public String getHome(){
        return "Funcionou";
    }
}
