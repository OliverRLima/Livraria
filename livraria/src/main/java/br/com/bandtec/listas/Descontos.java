package br.com.bandtec.listas;

import br.com.bandtec.classes.Desconto;

import java.util.ArrayList;
import java.util.List;

public class Descontos {

    private List<Desconto> listaDesconto;

    public Descontos() {
        this.listaDesconto = new ArrayList<>();
    }

    public void adicionaDesconto(Desconto desconto){
        this.listaDesconto.add(desconto);
    }

    public ArrayList<Desconto> getDescontos(){
        return (ArrayList<Desconto>) this.listaDesconto;
    }
}
