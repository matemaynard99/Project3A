import java.util.*;
//method to build binary tree
public class Build_tree {
	public static Node newTree(String s) {
		//add Open and Close parentheses to set equation range
		String input = "(" + s +")";
		//remove spaces
		input.replaceAll(" ", "");
		//stack to hold nodes while building
		Stack<Node> nodes = new Stack<Node>();
		Stack<String> operators = new Stack<String>();

		Node root, rootL, rootR;
		
		//for loop to run through whole equation
		for (int i =0; i<input.length(); i++){
			//new string for building string based nodes
		   String newString = "";
		   //ensures no spaces
		   if(input.charAt(i) == ' ') {
			   continue;
		   }
		 //if char is open parenthesis add to operators stack
		   if (input.charAt(i) == '('){
		      newString += input.charAt(i);
		      operators.push(newString);
		   }
		   //check if char is number
		   else if (Support.isNumber(input.charAt(i))){
			   //check for multi digit numbers
			   while(Support.isNumber(input.charAt(i))){
				   
				   newString += input.charAt(i);
				   i++;
		       }
			   //decriment i to maintain proper place in equation
		       i--;
		       //create and add new node to stack
		       root = Node.newNode(newString);
		       
		       nodes.push(root);
		   }
		   //check for close parenthsis
		   else if( input.charAt(i) == ')'){
			   //run through all operators in parentheses and add nodes based on them
		       while(!operators.isEmpty() && !operators.peek().equals("(")){
		    	   //sets operator as a node and sets children based on current node stack
		           root = Node.newNode(operators.peek());
		           operators.pop();
		           rootR = nodes.peek();
		           nodes.pop();
		           rootL = nodes.peek();
		           nodes.pop();
		           root.left = rootL;
		           root.right = rootR;
		           nodes.push(root);
		       }
		       //remove the open parenthesis
		       operators.pop();
		   }
		   //check for operators
		   else{
			   //check for multi char operators
		       while(!Support.isNumber(input.charAt(i)) && input.charAt(i) != ' ' && input.charAt(i) != '('){
		    	   
		           newString += input.charAt(i);
		           i++;
		       }
		       //decriment i to maintain place in equation
		       i--;
		       //check if current operator has lower precedence than top of operator stack
		       while (Support.precedence(newString) < Support.precedence(operators.peek())) {
		    	   
		    	   //sets operator as a node and sets children based on current node stack
		    	   root = Node.newNode(operators.peek());
			       operators.pop();
			       rootR = nodes.peek();
			       nodes.pop();
		           rootL = nodes.peek();
		           nodes.pop();
		           root.left = rootL;
		           root.right = rootR;
		           nodes.push(root);
		      }
		      //puts the operator on top of operator stack 
		      operators.push(newString);
		   }
		}//end for
		
		//root node is only node in stack at current time
		//sets root node
		root = nodes.peek();
		System.out.print("Result of ");
		//outputs expected equation
		Support.inorderTraversal(root);
		System.out.print("is: ");
		//outputs solution
		System.out.println(Support.evaluateTree(root));
		return root;
	}//end method
}//end class
