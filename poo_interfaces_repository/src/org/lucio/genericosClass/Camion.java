package org.lucio.genericosClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T>{

    private List<T> objetos;
    private int maximo;

    public Camion(int maximo) {
        this.maximo = maximo;
        this.objetos = new ArrayList<T>();
    }

    public void addObjeto(T objeto){
        if( objetos.size() < maximo ){
            objetos.add(objeto);
        } else {
            throw new RuntimeException("Máximo alcanzado");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return objetos.iterator();
    }
}
