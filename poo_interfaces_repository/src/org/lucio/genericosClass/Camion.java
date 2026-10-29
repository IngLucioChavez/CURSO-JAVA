package org.lucio.genericosClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion implements Iterable{

    private List objetos;
    private int maximo;

    public Camion(int maximo) {
        this.maximo = maximo;
        this.objetos = new ArrayList();
    }

    public void addObjeto(Object objeto){
        if( objetos.size() < maximo ){
            objetos.add(objeto);
        } else {
            throw new RuntimeException("Máximo alcanzado");
        }
    }

    @Override
    public Iterator iterator() {
        return objetos.iterator();
    }
}
