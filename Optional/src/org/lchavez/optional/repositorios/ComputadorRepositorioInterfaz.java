package org.lchavez.optional.repositorios;

import org.lchavez.optional.models.Computador;
import org.lchavez.optional.models.Procesador;

public interface ComputadorRepositorioInterfaz extends Repositorio<Computador>{

    boolean cambiarProcesador(int idComputador, Procesador procesador);

}
