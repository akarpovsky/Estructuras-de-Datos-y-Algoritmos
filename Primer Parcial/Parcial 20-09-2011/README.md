# Ejercicio 1: Árboles Binarios

La cátedra daba una implementación de un árbol binario típica en la que se utiliza la estrategia de que el árbol binario guarda dentro de si mismo dos árboles binarios 

	class BinaryTree<T>{
		BinaryTree<T> left, right;
	}

Luego pedía implementar el método estático:

public static <T> boolean checkPostOrder(List<T> values)

el cual recibe una lista de valores de tipo T y debe retornar true en el caso de que los valores de los nodos en el índice del recorrido postorder coincidan con los valores de la lista en dicho índice.

// Aclaración: La solución está implementada con un BST<T> que utiliza la estrategia de tener una clase estática que modele al nodo. La única variación para que funcione con BinaryTree<T> debería ser cambiar el "root" por "tris" al llamar al método y considerar que en cada llamada de la recursiva estoy pasando "el árbol / subarbol".