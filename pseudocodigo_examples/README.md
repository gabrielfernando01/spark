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
		* <code>map</code>: Aplica una transformación a cada elemento.
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
		* <code>map</code>: Aplica una función a cada elemento.
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

***		

3. **Mapas** (<code>Map</code>)

+ Descripción: 
Los mapas son colecciones de pares clave-valor. Las claves son únicas, pero los valores pueden repetirse. Son útiles para búsquedas rápidas por clave.
+ Ejemplos: 
<code>HashMap</code>, <code>TreeMap</code>, <code>LinkedHashMap</code>.
+ Operaciones aplicables:
	* Transformaciones: 
		* <code>mapValues</code>: Transforma los valores manteniendo las mismas claves. 
		* <code>map</code>: Transforma tanto claves como valores.
		* <code>flapMap</code>: Transforma y aplana los resultados.
	* Filtrado: 
		* <code>filterKeys</code>: Filtra para clave-valor basados en las claves.
		* <code>filter</code>: Filtra pares clave-valor basados en una condición.
		* <code>exists</code>: Verifica si al menos un par clave-valor cumple una condición.
		* <code>forall</code>. Verifica si todos los pares clave-valor cumplen una condición.
	* Reducción: 
		* <code>reduce</code>: Combina todos los pares clave-valor usando una operación binaria.
		* <code>fold</code>: Combina pares clave-valor con un valor inicial.
	* Operaciones especificas:
		* <code>get</code>: Obtiene el valor asociado a una clave (devuelve un <code>Option</code>).
		* <code>getOrElse</code>: Obtiene el valor asociado a una clave o un valor predeterminado.
		* <code>keys</code>/<code>values</code>: Obtiene todas las claves o valores.
		* <code>+</code>: Agrega un nuevo par clave-valor.
		* <code>-</code>: Elimina una clave.
		* <code>updated</code>: Actualiza el valor asociado a una clave.
			
***

4. **Iteradores** <code>Iterator</code>

* Descripción:
Los iteradores son colecciones que permiten recorrer elementos uno a la vez. No almacenan todos los elementos en memoria, lo que los hace útiles para grandes volúmenes de datos.
	
* Ejemplos:
<code>Iterator(1, 2, 3)</code>, <code>List(1, 2, 3)</code>