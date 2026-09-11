package org.lucioChavez.appAbstractas;

import org.lucioChavez.appAbstractas.form.elementos.select.Opcion;
import org.lucioChavez.appAbstractas.form.elementos.*;
import org.lucioChavez.appAbstractas.form.validador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppAbstractas {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new NoNuloValidador())
                .addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(20,1));

        InputForm password = new InputForm("password","password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(20,1));

        InputForm email = new InputForm("email","email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad","number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("experiencia",10,5);
        experiencia.setValorCampo("lo que sea");
        experiencia.addValidador(new NoNuloValidador())
                .addValidador(new LargoValidador(50,1));

        SelectForm lenguajes = new SelectForm("lenguajes");
        lenguajes.addValidador(new LargoValidador(50,1));
        lenguajes.addOpcion(new Opcion("Java",1))
            .addOpcion(new Opcion("Python",2))
            .addOpcion(new Opcion("NodeJs",3))
            .addOpcion(new Opcion("PHP",3).setSelected(true));

        username.setValorCampo("");
        password.setValorCampo("");
        email.setValorCampo("a@a");
        edad.setValorCampo("10");

        // Clase Anónima a partir de un tipo abstracto o interface
        // de uso único
        ElementoForm saludo = new ElementoForm("saludoTxt") {
            @Override
            public String dibujarHTML() {
                return "<input disabled type='text' name='"+this.nombreCampo+"' value='"+this.valorCampo+"'>";
            }
        };
        saludo.setValorCampo("saludo bloqueado");

        List<ElementoForm> elementos = Arrays.asList(
                username,
                password,
                email,
                edad,
                experiencia,
                lenguajes,
                saludo
        );

        // foreach - programación funcional (stream)
        elementos.forEach(e->{
            System.out.println(e.dibujarHTML());
        });

        elementos.forEach(e->{
            if( !e.esValido() ){
                //e.getErrores().forEach(err -> System.out.println(err));
                e.getErrores().forEach(System.out::println); //forma abreviada
            }
        });


    }
}
