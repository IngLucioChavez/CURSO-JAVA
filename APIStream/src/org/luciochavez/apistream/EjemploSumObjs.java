package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploSumObjs {
    public static void main(String[] args) {

        List<String> nombres = List.of(
                "Lucio Chávez",
                "Carlos Chávez",
                "Carlos Chávez",
                "María Delgado",
                "Juan Silva",
                "Dudu Phudu"
        );

        IntStream nombresAUsuario= nombres.stream()
                .map(EjemploOptionalSenior::desdeNombreCompleto)
                .distinct()
                .mapToInt(u -> u.getNombres().length()); //- retorna un IntStream para operar con los valores enteros

        //nombresAUsuario.forEach(System.out::println);
        //System.out.println(nombresAUsuario.sum());

        IntSummaryStatistics stats = nombresAUsuario.summaryStatistics();
        System.out.println(stats.getSum()); //- sumatoria
        System.out.println(stats.getMin()); //- minimo
        System.out.println(stats.getMax()); //- máximo
        System.out.println(stats.getAverage()); //- promedio

    }
}
