public class PasarPorReferencia {
    public static void main(String[] args) {
        Persona persona = new Persona(32,"Lucio");
        System.out.println(persona);
        test(persona);
        System.out.println(persona);

    }

    public static void test(Persona persona){ //paso de objeto x referencia

        persona.setNombre("Lucho");
        persona.setEdad(30);

    }

}

class Persona{
    private String nombre;
    private Integer edad;

    public Persona(Integer edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
