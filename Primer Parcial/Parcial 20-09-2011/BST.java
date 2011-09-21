import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BST<T> {
	
	private Comparator<T> cmp;
	private Node<T> root;
	
	public BST(Comparator<T> cmp){
		this.cmp = cmp;
	}
	
	
	
	public void add(T value){
		if(root == null)
			root = new Node<T>(value, null, null);
		else
			root = add(value, root);
	}
	
	private Node<T> add(T value, Node<T> node){
		if(node == null)
			return new Node<T>(value, null, null);
		else{
			int c = cmp.compare(value, node.value);
			
			if(c <= 0)
				node.left = add(value, node.left);
			else
				node.right = add(value, node.right);
		}
		
		return node;
	}
	
	public void printPreOrder(){
		printPreOrder(root);
	}
	
	public void printPostOrder(){
		printPostOrder(root);
	}
	
	public void printPreOrder(Node<T> node){
		
		if(node == null)
			return;
		
		System.out.println(node.value);
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	public boolean checkPostOrder(List<T> list){
		return checkPostOrder(root, list, 0) == null ? false:true;
	}
	
	private Integer checkPostOrder(Node<T> node, List<T> list, int level){
		
		
		if(node == null){
			return level-1;
		}
		
		if(node.left == null && node.right == null){
			if(level < list.size()){
				if(list.get(level).equals(node.value)){
					return level;
				}
			}
			
			return null;
		}
		
		Integer izq = checkPostOrder(node.left, list, level);
		
		if(izq == null){
			return null;
		}
		
		Integer der = checkPostOrder(node.right, list, izq+1); //ojo

		
		if(der == null)
			return null;
		
		int myIndex = der + 1;
		
		if(myIndex < list.size()){
			if(list.get(myIndex).equals(node.value)){
//				System.out.println("Son iguales, retorno: " + myIndex);
				return myIndex;
			}
		}
		
		return null;
	}

	public void printPostOrder(Node<T> node){
		
		if(node == null)
			return;
		
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.println(node.value);
	}
	
	public static class Node<T>{
		T value;
		Node<T> left;
		Node<T> right;
		
		public Node(T value, Node<T> left, Node<T> right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) {
		BST<Integer> myTree = new BST<Integer>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				
				if(o1 < o2)
					return -1;
				else if(o1 == o2)
					return 0;
				else
					return 1;
			}
		
		});
	
		myTree.add(15);
		myTree.add(20);
		myTree.add(13);
		myTree.add(1);
		myTree.add(18);
		myTree.add(500);
		
		List<Integer> myList = new ArrayList();
		myList.add(1);
		myList.add(13);
		myList.add(18);
		myList.add(500);
		myList.add(20);
		myList.add(15);
//		myList.add(1);
//		myList.add(13);
//		myList.add(20);
//
//		myList.add(15);
		
		
		
//		myTree.printPreOrder();
		myTree.printPostOrder();
		System.out.println(myTree.checkPostOrder(myList));
		
	}

}
