package modelo.materiales;

public class BaseEntity {

    private int id;
    private static int ultimoId;

    public BaseEntity(){
        id = ++ultimoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
