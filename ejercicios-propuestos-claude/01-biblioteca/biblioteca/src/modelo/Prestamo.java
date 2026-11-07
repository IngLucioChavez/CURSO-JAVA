package modelo;

import modelo.materiales.Material;
import modelo.personas.Socio;

import java.util.ArrayList;
import java.util.List;

public class Prestamo {

    private List<Material> materiales;
    private Socio socio;

    public Prestamo(Socio socio){
        this.socio = socio;
        materiales = new ArrayList<>();
    }

    public Socio getSocio() {
        return socio;
    }

    public Prestamo addMaterial(Material material){
        materiales.add(material);
        return this;
    }

    public List<Material> getMateriales() {
        return List.copyOf(materiales);
    }
}
