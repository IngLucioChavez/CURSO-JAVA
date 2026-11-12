package modelo.materiales;

import interfaces.Imprimible;

public class Revista extends Material implements Imprimible {

    private Integer paginas = 0;

    public Revista(String titulo, Integer anio, Genero genero, Integer paginas) {
        super(titulo, anio, genero);
        this.paginas = paginas;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {

        StringBuilder texto = new StringBuilder();
        texto.append(String.format("Tipo: %s\n",this.obtenerTipo()));
        texto.append(String.format("numero de páginas: %s\n",paginas));
        texto.append(super.toString());

        return texto.toString();
    }

    @Override
    public String obtenerTipo(){
        return "Revista";
    }

}
