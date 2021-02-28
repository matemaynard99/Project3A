//basic node class and structure
public class Node {
	String data;
	Node left, right;
	
	//create new node from data
	static Node newNode(String s) {
		Node n = new Node();
		n.data = s;
		n.left = n.right = null;
		return n;
	}
}
