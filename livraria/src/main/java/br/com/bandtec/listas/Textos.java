package br.com.bandtec.listas;

import br.com.bandtec.classes.*;

import java.util.ArrayList;
import java.util.List;

public class Textos {

    private List<Texto> listaTextos;

    public Textos() {
        this.listaTextos = new ArrayList<>();
    }

    public void adicionaTexto(Texto texto){
        listaTextos.add(texto);
    }

    public ArrayList<Texto> getTextos(){
        return (ArrayList<Texto>) this.listaTextos;
    }

    public ArrayList<Livro> getLivros(){
        ArrayList<Livro> livros = new ArrayList<>();

        for (Texto texto : listaTextos) {
            if(texto instanceof Livro){
                livros.add((Livro) texto);
            }
        }

        return livros;
    }

    public ArrayList<Quadrinho> getQuadrinhos(){
        ArrayList<Quadrinho> quadrinhos = new ArrayList<>();

        for (Texto texto : listaTextos) {
            if(texto instanceof Quadrinho){
                quadrinhos.add((Quadrinho) texto);
            }
        }

        return quadrinhos;
    }

    public ArrayList<Manga> getMangas(){
        ArrayList<Manga> mangas = new ArrayList<>();

        for (Texto texto : listaTextos) {
            if(texto instanceof Manga){
                mangas.add((Manga) texto);
            }
        }

        return mangas;
    }

    public ArrayList<TextoUsuario> getTextoUsuario(){
        ArrayList<TextoUsuario> textosUsuario = new ArrayList<>();

        for (Texto texto : listaTextos) {
            if(texto instanceof TextoUsuario){
                textosUsuario.add((TextoUsuario) texto);
            }
        }

        return textosUsuario;
    }

    public ArrayList<Produto> getProdutos(){
        ArrayList<Produto> produtos = new ArrayList<>();

        for (Texto texto : listaTextos) {
            if(texto instanceof Produto){
                produtos.add((Produto) texto);
            }
        }

        return produtos;
    }

    public void excluirTexto(int posicao){
        System.out.println(listaTextos.size());
        listaTextos.remove(posicao);
        System.out.println(listaTextos.size());
    }

    public Integer getSize(){
        return listaTextos.size();
    }
}
