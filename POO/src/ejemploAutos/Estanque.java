package ejemploAutos;

public class Estanque {
    private int capacidad;

    public Estanque() {
        capacidad = 40;
    }

    public Estanque(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Estanque{" +
                "capacidad=" + capacidad +
                '}';
    }
}
