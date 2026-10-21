package org.luciochavez.poointerfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Libro implements Imprimible{

    private List<Pagina> paginas;
    private String autor;
    private String titulo;
    private Genero genero;

    public Libro(String autor, Genero genero, String titulo) {
        this.autor = autor;
        this.genero = genero;
        this.titulo = titulo;
        this.paginas = new ArrayList<>();
    }

    public Libro addPagina(Pagina pagina){
        paginas.add(pagina);
        return this;
    }

    public String imprimir(){

        StringBuilder sb = new StringBuilder("Libro\n");
        sb.append(String.format("Titulo: %s\n",titulo))
            .append(String.format("Autor: %s\n",autor))
            .append(String.format("Genero: %s\n",genero.getGenero()));

        int i = 0;
        for(Imprimible pagina:paginas){
            sb.append(String.format("Pagina(%s): %s\n",++i,pagina.imprimir()));
        }

        return sb.toString();
    }

}
