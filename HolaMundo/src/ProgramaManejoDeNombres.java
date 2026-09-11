import java.util.List;
import java.util.stream.Collectors;

public class ProgramaManejoDeNombres {
    public static void main(String[] args) {

        List<String> nombres = List.of("Andres","Maria","Pepe");

        String cadenaFinal = nombres.stream()
                .map(
                name -> name.toUpperCase().charAt(1) + "." + name.substring(name.length()-2)
                )
                .collect(Collectors.joining("_"));

        System.out.println(cadenaFinal);

    }
}
