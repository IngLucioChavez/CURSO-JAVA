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

Actualizado: 2026-11-17

**Dónde nos quedamos:** ejercicio en pausa después del paso 7. Lo siguiente es el paso 8 (`Estante` y la matriz). Después vienen el `Main` final, el reporte, las excepciones (Sec23) y, al final, el Builder recursivo.

### Hecho
- [x] Modelo corregido: ids consecutivos por tipo, validaciones de `null` y de rangos en `Prestamo`, `Persona` pública, límite de días y de renovaciones centralizados en `Prestamo`.
- [x] Paso 1: interfaz `Copiable<T>` y constructores de copia en `Persona`, `Socio` y `SocioPremium`.
- [x] Paso 2: `AbstractaRepositorio<T extends BaseEntity & Copiable<T>>` guarda y entrega copias; `buscarOriginal` para uso interno.
- [x] Paso 3: `MaterialRepositorio`, `copiar()` y `actualizarDesde` en `Material`, `Libro`, `Revista` y `Dvd`.
- [x] Paso 4: se eliminó el contador de `Socio`; el límite se mide por préstamo.
- [x] Paso 5: `Prestamo` copiable, `actualizarDesde` y `PrestamoRepositorio`.
- [x] Paso 6: `BibliotecaServicio` con `prestar`, `devolver` y `renovar`. El cupo del socio se calcula sumando los materiales de sus préstamos activos, y se valida la disponibilidad del material. `Revista` y `Dvd` no son `Prestable`, y el servicio y `Prestamo.addMaterial` los rechazan.
- [x] Paso 7: `Utilidades.masAntiguo` (con `Comparable<? super T>`) e `imprimirTodo` (con `? extends Material`), en el paquete `util`.

### Pendiente
- [ ] **Paso 8:** `Estante<T extends Material>` (Iterable, capacidad máxima, `agregar` devuelve `boolean`) y una clase `Almacen` con `Estante<?>[][]` (pasillos por niveles), con colocación validada y búsqueda de un material por título que devuelva su pasillo y nivel.
- [ ] **`Main` final:** 8 o más materiales y 3 socios; listar, paginar y ordenar; prestar, devolver y renovar con el servicio; `instanceof` para distinguir `SocioPremium`; reporte con `String.format`.
- [ ] **Reporte:** préstamos vencidos (`estaVencido()`) y total por género.
- [ ] Decidir si `Material` tiene `diasPrestamo()` abstracto (días máximos por tipo de material).
- [ ] Decidir si se conserva `Libro.prestar(...)` de la interfaz `Prestable`; el servicio ya no lo usa.

### Excepciones (Sec23)
- [ ] Reemplazar los `false` y `null` de `Prestamo` (`addMaterial`, `extender`, `devolver`) por `IllegalArgumentException` (argumento inválido) e `IllegalStateException` (estado inválido).
- [ ] Excepciones propias para las reglas de negocio de `BibliotecaServicio`: `LimitePrestamosException`, `MaterialNoDisponibleException`, `MaterialNoEncontradoException`, `RangoInvalidoException`, `DevolucionIncompletaException`.
- [ ] Repositorios: `crearRegistro(null)`, `comparar` con un campo inexistente y `obtenerRegistros(pagina, n)` con valores inválidos.
- [ ] `numeroSocio` único: rechazar duplicados en `SocioRepositorio.crearRegistro`.
- [ ] `try/catch/finally` en el `Main`.

### Al final
- [ ] Builder con genéricos recursivos (`Material`, `Libro`, `Revista`, `Dvd`), paso a paso, partiendo de `Mamifero`.
