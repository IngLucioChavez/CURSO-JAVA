# Ejercicio 01 - Sistema de Biblioteca

**Nivel:** integrador (hasta la Sec22 - Genéricos)
**Opcional:** Sec23 - Manejo de Excepciones

## Objetivo
Construir un mini-sistema de préstamos que reutilice el repositorio genérico (`CrudRepositorio`, `Ordenable`, `Paginable`) y la interfaz `Imprimible` que ya desarrollaste.

## Estructura sugerida
```
01-biblioteca/src/org/lucio/biblioteca/
  modelo/        repositorio/        util/        Main.java
```

## Modelo
- `Material` (clase **abstracta**, extiende `BaseEntity`): `titulo`, `anio`, `Genero` (enum), método abstracto `diasPrestamo()`.
- `Libro`, `Revista`, `Dvd` heredan de `Material`. Cada uno se construye con **Builder con genéricos recursivos** (como `Mamifero`).
- `Socio` extiende `Persona`; `SocioPremium` extiende `Socio` con mayor límite de préstamos.
- `Prestamo`: `Material`, `Socio`, fecha de préstamo y de devolución (calculada con `Calendar` según `diasPrestamo()`).

## Interfaces
- `Imprimible` en todos los materiales, con un método `default` que genere una ficha resumida.
- `Prestable`: `prestar()` y `devolver()`.
- `Renovable`: un método `default` y uno `static`.
- `Libro` implementa `Prestable` y `Renovable` (herencia múltiple de interfaces).

## Repositorios
- `AbstractaListRepositorio<T extends BaseEntity>` y concretos `MaterialRepositorio` y `SocioRepositorio`.
- `comparar()` ordena por título, año o id, en `ASC` y `DESC`.
- Método genérico estático `<T extends Comparable<T>> T masAntiguo(T a, T b, T c)`.
- `imprimirTodo(List<? extends Material>)` con wildcard.

## Genéricos y arreglos
- `Estante<T extends Material>` con capacidad máxima, implementa `Iterable<T>` (como `Camion<T>`).
- Matriz `Estante[][]` (pasillos x niveles) con búsqueda por título.

## Main
1. Cargar 8 o más materiales y 3 socios.
2. Listar, paginar y ordenar.
3. Prestar y devolver; usar `instanceof` con pattern matching para distinguir `SocioPremium`.
4. Imprimir un reporte con `String.format` y `StringBuilder`.

## Criterios de aceptación
1. Los IDs se autoincrementan desde `BaseEntity`.
2. Socio normal: máximo 3 materiales a la vez; premium: máximo 6.
3. El reporte final muestra los préstamos vencidos y el total por género.

## Opcional: Excepciones (Sec23)
Tu código actual tiene puntos que las excepciones resuelven:
- `editar()` lanza `NullPointerException` si el id no existe.
- `listar(desde, hasta)` lanza `IndexOutOfBounds` con rangos inválidos.
- `Camion` lanza un `RuntimeException` genérico.

Crea `MaterialNoEncontradoException`, `LimitePrestamosException` y `RangoInvalidoException`, y usa `try/catch/finally` en el `Main`.

## Temas que integra
Primitivos y wrappers, `String`/`StringBuilder`, `Calendar`, arreglos y matrices, `static`, `enum`, Builder, herencia, clases abstractas, paquetes, interfaces (`default`/`static`/múltiple), genéricos (métodos, clases, límites, wildcards), colecciones y lambdas.
