package org.workerbee.sortingalgorithms;

public class TreeSort {
	// Clase que representa un nodo en el árbol binario de búsqueda (BST)
	class Node {
		int key;
		Node left, right;

		// Constructor para inicializar un nodo con una clave dada
		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	// Raíz del árbol BST (árbol de búsqueda binario)
	Node root;

	// Constructor de la clase TreeSort
    public TreeSort() {
		root = null;
	}

	// Este método principal llama a insertRec()
	void insert(int key) {
		root = insertRec(root, key);
	}

	/* Una función recursiva para insertar una nueva clave en el BST */
	Node insertRec(Node root, int key) {
		/* Si el árbol está vacío, retorna un nuevo nodo */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* De lo contrario, se recurre por el árbol */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* Retorna la raíz */
		return root;
	}

	// Método para realizar un recorrido en orden (inorder traversal) del BST
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}

	// Método para insertar un arreglo de claves en el árbol BST
    public void treeins(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i]);
		}
	}
}
