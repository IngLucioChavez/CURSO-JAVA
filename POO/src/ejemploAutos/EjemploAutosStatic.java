package ejemploAutos;

import java.util.Date;

public class EjemploAutosStatic {
    public static void main(String[] args) {

        Auto auto1 = new Auto(Color.AMARILLO,"mazda",TipoAuto.CONVERTIBLE);
        Auto auto2 = new Auto(Color.AZUL,"totoya",TipoAuto.FURGON);
        Auto auto3 = new Auto(Color.NEGRO,"totoya",TipoAuto.HATCHBACK);
        Auto auto4 = new Auto(Color.NEGRO,"chevrolet");
        auto4.setTipo(TipoAuto.CONVERTIBLE);

        TipoAuto tipoAuto4 = auto4.getTipo();

        // estructura de switch no necesita break
        // a partir de Java SE 14+
        switch(tipoAuto4){
            case COUPE -> {
                System.out.println("COUPE");
            }
            case HATCHBACK -> {
                System.out.println("HATCHBACK");
            }
            case FURGON -> {
                System.out.println("FURGON");
            }
            case null, default -> {
                System.out.println("DESCONOCIDO");
            }
        }

        TipoAuto[] tiposAuto = TipoAuto.values();
        for(TipoAuto ta: tiposAuto){
            System.out.println(
                ta.name() + "=> " + ta.getDescripcion()
                + " " + ta.getNombre() + " " + ta.getNumeroPuertas()
            );
            System.out.println(ta + "\n");
        }


    }
}
