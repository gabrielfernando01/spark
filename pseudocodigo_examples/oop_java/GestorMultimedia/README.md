![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/pseudocodigo_examples/image/cover_multimediaProject.png)

# Gestor de Contenido Multimedia 📺🕹️

**🎯 Objetivo del proyecto**

El proyecto "Gestor de Contenido Multimedia" tiene como propósito crear un sistema simple para registrar, gestionar y comparar contenido multimedia, específicamente series de televisión 📺 y videojuegos 🕹️. Este sistema permite a un usuario 🙋🏼 organizar su colección personal, llevar un control de qué elementos han sido prestados o utilizados, y destacar los más extensos en términos de duración (temporadas para series 📺 y horas para videojuegos 🕹️). El objetivo es ofrecer una herramienta básica pero funcional para administrar y analizar estos elementos de entretenimiento.

**📐 Reglas del negocio**

1. Entidades del Sistema

El sistema gestiona dos tipos de contenido multimedia: Series y Videojuegos.

Class Serie 📺.

- ✏️ Atributos 

	+ <code>title</code>: Nombre de la serie (texto).
	+ <code>numberOfSeason</code>: Cantidad de temporadas (número entero, por defecto 3).
	+ <code>delivered</code>: Estado de entrega (verdadero/falso, por defecto falso).
	+ <code>genre</code>: Categoria de la serie (texto, e.g., "drama", "comedia").
	+ <code>creator</code>: Nombre del creador o showrunner (texto).
	
- ⚙️ Constructores:

	+ Por defecto: Crea una serie con 3 temporadas y no entregada; el resto de atributos con valores vacío o nulos.
	+ Con título y creador: Configura esos dos valores, dejando  el resto por defecto.
	+ Completo (excepto <code>delivered</code>): Permite definir todos los atributos menos el estado de entrega, que inicia en falso.

- ✨ Métodos:

	+ Método para consultar (<code>get</code>) todos los atributos, excepto <code>delivered</code>.
	+ Método para modificar (<code>set</code>) todos los atributos, excepto <code>delivered</code>.
	+ Representación en texto: Devuelve una descripción legible del videojuego 🎮 (método <code>toString</code>).
	
2. Funcionalidad Común: Interfaz Entregable.

Ambas clases, <code>Serie</code> y <code>Videojuego</code>, implementan una interfaz <code>Entregable</code> que define acciones relacionadas con el estado de entrega y comparación:

+ <code>deliver</code>: Cambia el estado de <code>delivered</code> a verdadero (simula prestar o marcar como usado).
+ <code>returnItem()</code>: Cambia el estado de <code>delivered</code> a falso (simula devolver o marcar como disponible).
+ <code>isDelivered()</code>: Devuelve el estado actual de <code>delivered</code>.
+ <code>compareTo(Object a)</code>: Compara dos objetos según su duración:

	+ Para <code>Serie</code>: Compara el número de temporadas.
	+ Para <code>Videojuego</code>: Compara las horas estimadas.
	+ Usa conversión de tipos (casting) para manejar el objetivo recibido como parámetro.
	
3. Aplicación Principal.

La aplicación ejecutable reliza las siguientes tareas 📋:

3.1 Creción de colecciones:

+ Genera una lista de 5 series 📺 y otra de 5 videojuegos 🕹️.
