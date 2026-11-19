package modelo;

public enum Ciudad {
    NEW_YORK("New York", "Estados Unidos"),
    SAO_PAULO("Sao Paulo", "Brasil"),
    RIO_DE_JANEIRO("Rio De Janeiro", "Brasil"),
    ATLANTA("Atlanta", "Estados Unidos"),
    BOGOTA("Bogota", "Colombia"),
    MEXICO_CITY("Mexico City", "México"),
    LONDRES("Londres", "Reino Unido"),
    FRANKFURT("Frankfurt", "Alemania"),
    LIMA("Lima", "Perú"),
    LOS_ANGELES("Los Ángeles", "Estados Unidos"),
    GUAYAQUIL("Guayaquil", "Ecuador"),
    PANAMA_CITY("Panama City", "Panamá"),
    MADRID("Madrid", "España"),
    MIAMI("Miami", "Estados Unidos"),
    BUENOS_AIRES("Buenos Aires", "Argentina"),
    CANCUN("Cancún", "México"),
    BARCELONA("Barcelona", "España"),
    DALLAS_FORT_WORTH("Dallas-Fort Worth", "Estados Unidos"),
    PARIS("París", "Francia"),
    MONTEVIDEO("Montevideo", "Uruguay"),
    SANTIAGO("Santiago", "Chile");

    private final String nombre;
    private final String pais;

    Ciudad(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
