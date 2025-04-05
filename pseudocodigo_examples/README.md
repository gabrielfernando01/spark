![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/pseudocodigo_examples/image/cover_project.png)

# Projectos en Scala 🟥, Java ☕, Spark ⭐.

Este repositorio contiene diversos projectos ...

## Estructuras de datos en Scala 🟥.

1. **Secuencias** (<code>Seq</code>).
+ Descripción: 
Las secuencias son colecciones ordenadas de elementos donde el orden de inserción se mantiene. Pueden contener elementos duplicados.
+ Ejemplos: 
<code>List</code>, <code>Vector</code>, <code>ArrayBuffer</code>, <code>Range</code>.
+ Operaciones aplicables: 
	* Transformaciones:
		* <code>map</code>: Transforma cada elemento.
		* <code>flatMap</code>: Transforma y aplana los resultados.
		* <code>collect</code>: Aplica una función parcial a los elementos que coinciden.
	* Filtrado:
		* <code>filter</code>: Filtra elementos basados en una condición.
		* <code>filterNot</code>: Filtra elementos que no cumplen una condición.
		* <code>takeWhile</code>/<code>dropWhile</code>: Toma o elimina elementos mientras se cumple una condición.
	* Reducción:
		* <code>reduce</code>: Combina todos los elementos usando una operación binaria.
		* <code>fold</code>: Combina elementos con valor inicial.
		* <code>scan</code>: Realiza reducciones acumulativas mostrando los pasos intermedios.
	* Operciones especificas de secuencias:
		- <code>head</code>/<code>tail</code>: Obtine el primer elemento o el resto de la secuencia.
		- <code>reverse</code>: Invierte el orden de los elementos.
		- <code>zip</code>/<code>unzip</code>: Combina o separa dos secuencias en pares.
		
***
		
2. **Conjuntos** (<code>Set</code>).

+ Descripción:
Los conjuntos son colecciones no ordenadas que no permiten elementos duplicados. Son útiles para verificar pertenencia rápida.
+ Ejemplos:
<code>HashSet</code>, <code>TreeSet</code>, <code>LinkedHashSet</code>.
+ Operaciones aplicables:
	* Transformaciones: 
		* <code>map</code>: Transforma cada elemento.
		* <code>flatMap</code>: Transforma y aplana los resultados.
	* Filtrado: 
		* <code>filter</code>: Filtra elementos basados en una condición.
		* <code>exists</code>: Verifica si al menos un elemento cumple una condición.
		* <code>forall</code>: Verifica si todos los elementos cumplen una condición.
	* Reducción:
		* <code>reduce</code>: Combina todos los elementos usando una operación binaria.
		* <code>fold</code>: Combina elementos con un valor inicial.
	* Operaciones especificas de conjuntos: 
		* <code>union</code>: Combina dos conjuntos elimanando duplicados.
		* <code>intersect</code>: Encuentra la intersección entre dos conjuntos.
		* <code>diff</code>: Encuentra la diferencia entre dos conjuntos.
		* <code>subsetOf</code>: Verifica si un conjunto es subconjunto de otro.

**
		
3. **Mapas** (<code>Map</code>)

+ Descripción: 
Los mapas son colecciones de pares clave-valor. Las claves son únicas, pero los valores pueden repetirse. Son útiles para búsquedas rápidas por clave.
+ Ejemplos: 
<code>HashMap</code>, <code>TreeMap</code>, <code>LinkedHashMap</code>.
+ Operaciones aplicables:
	* Transformaciones: <code></code>, <code></code>.
	* Filtrado: <code></code>, <code></code>.
	* Reducción: <code></code>, <code></code>.
	* Operaciones especificas: 
			
***

4. **Iteradores**

	* Descripción: Colecciones que generan	
		 
	
## Programación Funcional sobre coleccciones.

1. Transformaciones:

	+ Modificar cada elemento de una colección mediante funciones como <code></code>, <code></code>, <code></code>.
	
2. Filtrado:

	+ Seleccionar <code></code>, <code></code>, <code></code>.
	* <code>exists</code>: Verificar si al menos un elemento cumple una condición.
		* <code>forall</code>: Verifica si todos los elementos cumplen una condición.
3. Reducción:

	+ Combinar todos