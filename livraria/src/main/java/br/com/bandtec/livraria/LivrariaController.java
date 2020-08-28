package br.com.bandtec.livraria;

import br.com.bandtec.classes.*;
import br.com.bandtec.listas.Descontos;
import br.com.bandtec.listas.Textos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LivrariaController {

    private Textos textos = new Textos();
    private Descontos descontos = new Descontos();

    private Boolean primeiraAdicao = true;

    private void adicionaConteudoInicial(){

        primeiraAdicao = false;

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

        descontos.adicionaDesconto(quadrinho);

        textos.adicionaTexto(livro);
        textos.adicionaTexto(manga);
        textos.adicionaTexto(quadrinho);
        textos.adicionaTexto(textoUsuario1);
        textos.adicionaTexto(textoUsuario2);
        textos.adicionaTexto(textoUsuario3);
    }


    @GetMapping
    public String getHome(){
        return "Bem vinda a Livraria! \n Compre livros, mangas ou quadrinhos e se quiser divulgue seus " +
                "textos aqui.";
    }

    @GetMapping("/explorar/{parametro}")
    public List<? extends Texto> getTextos(@PathVariable String parametro){
        ArrayList<Texto> listaVazia = new ArrayList<>();

        if(primeiraAdicao == true){
            adicionaConteudoInicial();
        }

        switch (parametro){
            case "produtos":
                return this.textos.getProdutos();
            case "livros":
                return this.textos.getLivros();
            case "mangas":
                return this.textos.getMangas();
            case "quadrinhos":
                return this.textos.getQuadrinhos();
            case "textos":
                return this.textos.getTextoUsuario();
            case "tudo":
                return this.textos.getTextos();
            default:
                break;
        }

        return listaVazia;
    }

    @GetMapping("/excluir/{parametro}")
    public String excluirTextoUsuario(@PathVariable int parametro){

        Texto temDesconto = textos.getObjeto(--parametro);

        if(parametro < 0 ){
            return "Não há nada nessa posição";
        } else if(parametro >= 0 && parametro <= textos.getSize()){
            textos.excluirTexto(--parametro);

            System.out.println(temDesconto);

            if(temDesconto instanceof Desconto){
                descontos.excluiDesconto(--parametro);
            }

            return "Excluido";
        }

        return "Não há nada nessa posição";
    }

    @GetMapping("/desconto")
    public ArrayList<Desconto> getDesconto(){
        return this.descontos.getDescontos();
    }
}
