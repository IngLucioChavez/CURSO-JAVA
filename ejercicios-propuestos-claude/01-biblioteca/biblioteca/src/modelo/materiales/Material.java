package modelo.materiales;

import modelo.BaseEntity;
import modelo.interfaces.Copiable;

public abstract class Material extends BaseEntity implements Copiable<Material> {

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

    protected Material(Material otro){
        super(otro.getId());
        this.titulo = otro.titulo;
        this.anio = otro.anio;
        this.genero = otro.genero;
    }

    public void actualizarDesde(Material otro){
        this.titulo = otro.titulo;
        this.anio = otro.anio;
        this.genero = otro.genero;
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
