# Ejercicio 1: Árboles Binarios

La cátedra daba una implementación de un árbol binario típica en la que se utiliza la estrategia de que el árbol binario guarda dentro de si mismo dos árboles binarios 

	class BinaryTree<T>{
		BinaryTree<T> left, right;
	}

Luego pedía implementar el método estático:

	public static <T> boolean checkPostOrder(List<T> values)

el cual recibe una lista de valores de tipo T y debe retornar true en el caso de que los valores de los nodos en el índice del recorrido postorder coincidan con los valores de la lista en dicho índice.

<strong>Aclaración:</strong> La solución está implementada con un BST<T> que utiliza la estrategia de tener una clase estática que modele al nodo. La única variación para que funcione con BinaryTree<T> debería ser cambiar el "root" por "tris" al llamar al método y considerar que en cada llamada de la recursiva estoy pasando "el árbol / subarbol".
	
# Ejercicio 2: Lístas Circulares

####Se tiene la interfaz <strong>CircularList<T></strong> que modela una lista circular simplemente encadenada.
	
	public Interface CircularList<T>{
		
		/* Recibe un objeto de tipo T y lo agrega al final de la lista */
		
		public void addLast(T value);
		
		/* Cada vez que es llamado, devuelve el siguiente elemento de la lista (como si fuera un iterador).
		Si la lista está vacía, lanza una excepcion NoSuchElementException */
		
		public T getNext();
		
		/* Retorna una nueva lista que contiene los elementos desde el último que fue devuelto por getNext() 
		hasta el último elemento de la lista. Es decir que la lista original (this) queda con los elementos 
		que van desde el primer elemento hasta el último devuelto por getNext() y el método devuelve una nueva 
		lista con los restantes. En caso de invocarse a split() sin antes haber	llamado a getNext() lanza una 
		excepción IllegalStateException */
		
		public CircularList<T> split();	
	}
	
Se pide realizar una implementación de la interfaz CircularList<T> <strong>sin utilizar la API de Java y con todos los métodos resueltos con órden de complejidad temporal = 1 O(1)</strong>
	
# Ejercicio 3: Árboles

Se tiene una implementación de árboles que sólo guarda información en sus hojas. Las hojas pueden guardar hasta N datos, donde N es un parámetro que se pasa a través del constructor. Los nodos intermedios sólo guardan referencias para luego acceder a la información.

Se pide:

a) Implementar la estructura de la clase (sólo estructura NO métodos!)
b) Implementar el métodos <strong>boolean belongs(T value)</strong> que devuelve verdadero o falso dependiendo de si el valor que se le pasa pertenece o no al árbol.

<strong>Aclaración:</strong> Se puede utilizar la API de Java.
