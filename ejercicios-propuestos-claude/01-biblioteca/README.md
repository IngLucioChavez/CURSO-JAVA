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
- `Libro` implementa `Prestable` y `Renovable` (herencia múltiple de modelo.interfaces).

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
Primitivos y wrappers, `String`/`StringBuilder`, `Calendar`, arreglos y matrices, `static`, `enum`, Builder, herencia, clases abstractas, paquetes, modelo.interfaces (`default`/`static`/múltiple), genéricos (métodos, clases, límites, wildcards), colecciones y lambdas.

## Pendientes y avance

Actualizado: 2026-11-12

### Corregir en el modelo (antes de los repos)
- [x] `Prestamo(Socio, LocalDate)`: usa `this.fechaFinalPrestamo` al calcular `diasPrestamo`; hoy usa el parámetro, que puede ser `null`, y lanza NPE.
- [x] Decidir si un `LocalDate` null debe lanzar error en lugar de asumir 30 días en silencio.
- [x] Opcional: validar los días antes de `super(++ultimoId)` también en el constructor de `LocalDate`, para no gastar ids.
- [x] Hacer `Persona` pública.
- [x] Validar que `socio` no sea `null` en los constructores de `Prestamo`.

### Repositorios
- [ ] `CrudRepositorio<T>`: listar, porId, crear, editar, eliminar.
- [ ] `OrdenableRepositorio`, `PaginableRepositorio`, `ContableRepositorio`, enum `Direccion` (ASC/DESC) y la interfaz que las agrupa. Reutilizar lo de `poo_interfaces_repository`.
- [ ] `AbstractaListRepositorio<T extends BaseEntity>`.
- [ ] `MaterialRepositorio` y `SocioRepositorio`, con `comparar()` por título, año o id.
- [ ] `PrestamoRepositorio`.
- [ ] Servicio (`BibliotecaServicio`) que coordine prestar, devolver y renovar usando los repos.
- [ ] Regla de disponibilidad: un material no puede estar en dos préstamos activos a la vez.
- [ ] Decidir si el límite del socio se calcula contando préstamos activos en el repo o se mantiene el contador `prestamosRegistrados`.
- [ ] Método genérico `<T extends Comparable<T>> T masAntiguo(T a, T b, T c)`.
- [ ] `imprimirTodo(List<? extends Material>)` con wildcard.

### Después de los repos
- [ ] `Estante<T extends Material>` (Iterable, capacidad máxima) y la matriz de estantes con búsqueda por título.
- [ ] `Main` final: 8 o más materiales y 3 socios; listar, paginar y ordenar; prestar y devolver; `instanceof` con `SocioPremium`; reporte con `String.format`.
- [ ] Reporte: préstamos vencidos (`estaVencido()`) y total por género.

### Excepciones (Sec23, tras los repos)
- [ ] Cambiar los `false` de `Prestamo` por excepciones: `IllegalArgumentException` (argumentos inválidos) e `IllegalStateException` (estado inválido).
- [ ] Excepciones propias: `LimitePrestamosException`, `MaterialNoDisponibleException`, `MaterialNoEncontradoException`, `RangoInvalidoException`, `DevolucionIncompletaException`.
- [ ] `Libro.prestar` deja de devolver `null`.
- [ ] `try/catch/finally` en el `Main`.

### Al final
- [ ] Builder con genéricos recursivos (`Material`, `Libro`, `Revista`, `Dvd`), paso a paso, partiendo de `Mamifero`.
- [ ] Decidir si `Material` tiene `diasPrestamo()` abstracto (días máximos por tipo) y si `Revista`/`Dvd` serán `Prestable`/`Renovable`.
