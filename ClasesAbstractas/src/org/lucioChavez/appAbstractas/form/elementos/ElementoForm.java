package org.lucioChavez.appAbstractas.form.elementos;

import org.lucioChavez.appAbstractas.form.validador.Validador;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoForm {

    protected String valorCampo;
    protected String nombreCampo;
    protected List<Validador> validadores;
    protected List<String> errores;

    public ElementoForm() {
        validadores = new ArrayList<>();
        errores = new ArrayList<>();
    }

    public ElementoForm(String nombreCampo) {
        this();
        this.nombreCampo = nombreCampo;
    }

    public ElementoForm addValidador(Validador validador){
        validadores.add(validador);
        return this;
    }

    public List<String> getErrores(){
        return errores;
    }

    public void setValorCampo(String valorCampo) {
        this.valorCampo = valorCampo;
    }

    public boolean esValido(){
        for(Validador v: validadores){
            if( !v.esValido(valorCampo) ){
                errores.add(String.format("para campo [%s]: %s",nombreCampo,v.getMensaje()));
            }
        }
        return errores.isEmpty();
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    abstract public String dibujarHTML();
}
