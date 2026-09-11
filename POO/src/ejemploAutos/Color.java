package ejemploAutos;

//el valor de la constantes es el mismo que el nombre
// ROJO = 'ROJO'
public enum Color {
    //se comportan como constructores los valores definidos
    ROJO("Rojo"),
    AMARILLO("Amarillo"),
    AZUL("Azul"),
    NEGRO("Negro"),
    NARANJA("Naranja");

    private final String color;

    Color(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color;
    }
}
