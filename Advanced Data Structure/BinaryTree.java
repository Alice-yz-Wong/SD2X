package W2;

public class BinaryTree {
	class Node{
		int value;
		Node leftChild=null;
		Node rightChild=null;
		Node(int value){
			this.value=value;
		}
		
		protected Node root=null;
	}
	
	
	//Traversal: use recursion
	public void inorderTraversal(Node n) {
		if(n==null) return;
		inorderTraversal(n.leftChild);
		visit(n);
		inorderTraversal(n.rightChild);
	}
	
	public void visit(Node n) {
		System.out.println(n.value);
	}
	
	//Contains:
	public boolean BTSContains(Node n, int val) {
		if(n==null) return false;
		if(n.value>val) {
			return BTSContains(n.leftChild, int val);
		}else if(n.value<val) {
			return BTSContains(n.rightChild,int val);
		}else if(n.value==val) {
			return true;
	}
		
	//Add value:
	public boolean BTSAdd(Node n, int val) {
		if(n.value==val) {
			return false;
		}else if (n.value>val) {
			return BTSAdd(n.leftChild,val);
		}else if (n.value<val) {
			return BTSAdd(n.rightChild, val);
		}
	}
	
	//Remove value;
	public boolean BTSRemove(Node n, Node parent, int val) {
		if(n==null) return false;
		if(val<n.value) {
			return BTSRemove(n.leftChild,n,val);
		}else if(val>n.value) {
			return BTSRemove(n.rightChild,n,val);
		}else {
			if(n.leftChild!=null&&n.rightChild!=null) {
				n.value=maxValue(n.leftChild);
				BTSRemove(n.leftChild,n,n.value);
			}else if(parent.leftChild==n) {
				parent.leftChild=n.leftChild?n.leftChild:n.rightChild;
			}else {
				parent.rightChild=n.leftChild?n.leftChild:rightChild;
			}
			return true;
		}		
	}
	
	//red-black tree, self balance binary tree
	
		
 

}
