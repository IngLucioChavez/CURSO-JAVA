package org.lucioChavez.appAbstractas.form.elementos;

import org.lucioChavez.appAbstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementoForm{

    private List<Opcion> opciones;

    public SelectForm(String nombreCampo) {
        super(nombreCampo);
        opciones = new ArrayList<>();
        super.valorCampo = "default";
    }

    public SelectForm(String nombreCampo, List<Opcion> opciones) {
        super(nombreCampo);
        this.opciones = opciones;
        super.valorCampo = "default";
    }

    public SelectForm addOpcion(Opcion opcion){
        opciones.add(opcion);
        return this;
    }

    @Override
    public String dibujarHTML() {

        StringBuilder sb = new StringBuilder("<select ");
            sb.append("name='").append(nombreCampo).append("'>");

        for(Opcion opcion: opciones){
            sb.append("\n\t<option value='")
                    .append(opcion.getValor()).append("'")
                    .append(opcion.isSelected() ? " selected": "")
                    .append(">");
            sb.append(opcion.getDescripcion());
            sb.append("</option>");
        }

        sb.append("\n</select>");

        return sb.toString();
    }
}
