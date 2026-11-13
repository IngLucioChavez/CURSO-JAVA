package modelo.materiales;

import modelo.BaseEntity;

public abstract class Material extends BaseEntity {

    protected String titulo;
    protected Integer anio;
    protected Genero genero;
    private static int ultimoId;

    public Material(String titulo, Integer anio, Genero genero){
        super(++ultimoId);
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {

        StringBuilder texto = new StringBuilder();
        texto.append(String.format("Titulo: %s\n",titulo));
        texto.append(String.format("Año: %s\n",anio));
        texto.append(String.format("Genero: %s\n",genero));

        return texto.toString();
    }
}
