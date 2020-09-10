package br.com.bandtec.livraria;

import br.com.bandtec.classes.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livraria")
public class LivrariaController {

    private List<Texto> textos = new ArrayList<>();
    private List<Desconto> descontos = new ArrayList<>();

    private Boolean primeiraAdicao = true;

    private void adicionaConteudoInicial(){

        this.primeiraAdicao = false;

        Livro livro = new Livro("A Guerra dos tronos","O início da épica saga de George R.R.Martin",
                "George R.R.Martin","LeYa", 1057, 30, 10.0);

        Manga manga = new Manga("My Hero Academia, Vol 1",
                "\n" +
                        "Como seria o mundo se 80% da população manifestasse superpoderes chamados de “Individualidades” aos" +
                        " quatro anos? Heróis e vilões estariam lutando em todos os lugares! Ser um herói significaria" +
                        " aprender a usar seu poder, mas onde você iria estudar? " +
                        "A Hero Academy, é claro! Mas o que você faria se fosse um dos 20 por cento que nasceram sem Individualidade?",
                "Kouhei Horikoshi","Jump Comics", 192, 80, 10.0);

        Quadrinho quadrinho = new Quadrinho("Batman - Ano um",
                "\n" +
                        "Conta os eventos que levaram Bruce Wayne a se tornar o Batman e seu primeiro ano no combate ao crime.",
                "Frank Miller", "Panini Books", 104, 20, 40.0);

        TextoUsuario textoUsuario1 = new TextoUsuario("Uma história", "Sobre uma história", "Historiador",
                "Primeiro capítulo", "Era uma vez, ou talvez não...");

        TextoUsuario textoUsuario2 = new TextoUsuario("Outra história", "Aquela outra história", "Historiador",
                "Primeiro capítulo", "Em um lugar muito distante...");

        TextoUsuario textoUsuario3 = new TextoUsuario("Mais uma história", "Mais uma história", "Historiador",
                "Primeiro capítulo", "Agora a criatividade falhou...");

        descontos.add(quadrinho);

        textos.add(livro);
        textos.add(manga);
        textos.add(quadrinho);
        textos.add(textoUsuario1);
        textos.add(textoUsuario2);
        textos.add(textoUsuario3);
    }


    @GetMapping
    public ResponseEntity getHome(){
        if (textos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(textos);
        }
    }

    @GetMapping("/{parametro}")
    public ResponseEntity getTextos(@PathVariable String parametro){

        if(primeiraAdicao == true){
            adicionaConteudoInicial();
        }
        ArrayList<Texto> listaTexto = new ArrayList<>();

        switch (parametro){
            case "livros":
                listaTexto = (ArrayList<Texto>) textos.stream()
                        .filter(texto -> texto instanceof Livro)
                        .collect(Collectors.toList());
                break;
            case "mangas":
                listaTexto = (ArrayList<Texto>) textos.stream()
                        .filter(texto -> texto instanceof Manga)
                        .collect(Collectors.toList());
                break;
            case "quadrinhos":
                listaTexto = (ArrayList<Texto>) textos.stream()
                        .filter(texto -> texto instanceof Quadrinho)
                        .collect(Collectors.toList());
                break;
            case "textos":
                listaTexto = (ArrayList<Texto>) textos.stream()
                        .filter(texto -> texto instanceof Texto)
                        .collect(Collectors.toList());
                break;
            default:
                break;
        }

        if (listaTexto.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(listaTexto);
        }
    }

    @DeleteMapping("/{parametro}")
    public ResponseEntity excluirTextoUsuario(@PathVariable int parametro){
        if (textos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if(textos.size() < parametro){
            return ResponseEntity.notFound().build();
        } else{

            Texto temDesconto = textos.get(parametro - 1);
            textos.remove(parametro - 1);

            if(temDesconto instanceof Desconto){
                descontos.remove(temDesconto);
            }

            return ResponseEntity.ok().build();
        }


    }

    @GetMapping("/desconto")
    public ResponseEntity getDesconto(){
        if (descontos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(descontos);
        }
    }
}
