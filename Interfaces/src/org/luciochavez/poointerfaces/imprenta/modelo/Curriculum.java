package org.luciochavez.poointerfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Hoja{

    private String persona;
    private String carrera;
    private List<String> experiencias;

    public Curriculum(String persona, String carrera, String contenido) {
        super(contenido);
        this.persona = persona;
        this.carrera = carrera;
        this.experiencias = new ArrayList<>();
    }

    public Curriculum addExperiencia(String experiencia){
        this.experiencias.add(experiencia);
        return this;
    }

    @Override
    public String imprimir() {

        StringBuilder builder = new StringBuilder();
        builder.append("Nombre: ").append(persona).append("\n")
                .append("Carrera: ").append(carrera).append("\n")
                .append("Resumen: ").append(contenido).append("\n")
                .append("Experiencias: ").append("\n");

        int i = 0;
        for(String experiencia: experiencias){
            builder.append(String.format("(%s) experiencia:",++i)).append(experiencia).append("\n");
        }

        return builder.toString();
    }
}
