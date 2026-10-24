package org.lucio.poointerfaces.modelo;

public class ClientePremium extends Cliente implements Comparable<ClientePremium>{

    public ClientePremium(String apellido, String nombre) {
        super(apellido, nombre);
    }

    @Override
    public int compareTo(ClientePremium o) {
        return 0;
    }
}
