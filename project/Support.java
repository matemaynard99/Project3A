public class Support {
	/**
	 * 
	 * @param left: int value to be evaluated
	 * @param right: int value to be evaluated
	 * @param s: string that holds the operator
	 * @return
	 */
	static public int equation(Integer left, Integer right, String s) {
		
		switch(s) {
        
		default: return 0;
	    case "+":
	        return(left + right);	     
	    
	    case "-":
	        return(left - right);
	        
	    case "*":
	        return(left * right);

	    case "/":
	        return(left / right);
	    case "%":
	    	return (left % right);
	        
	    case "^":
	        return (int) (Math.pow(left, right));
	        
	    case ">":
	        if(left > right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }	   
	        
	    case "<":
	        if(left < right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }
	      	        
	    case ">=":
	        if(left >= right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }
	  	        
	    case "<=":
	        if(left <= right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }
		        
	    case "==":
	        if(left == right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }
	        	        
	    case "!=":
	        if(left != right) {
	            return 1;
	        }
	        else {
	            return 0;
	        }		
	        
	    case "&&":
	    	return (left & right);
	        	    
	    case "||":
	    	return (left ^ right);
	        
	    
		}//end switch
	}//end class equation
	
	//simple method to see if char is between 1-9 and thus a number
	static public boolean isNumber(char c) {
		if(c >= '0' && c <='9')
			return true;
		else
			return false;
	}//end is number check
	/*
	*Method to check if String s is equal to any of the allowed operators for this project. 
	*Returns: True if String s is equal to one of the operators, otherwise returns false bvecause String s isnt an operator
	*/
	/**
	 * 
	 * @param s: String holding characters that check if String s is a valid operator
	 * @return: true if String s is a valid operator, false if String s is not a valid operator
	 */
	static public boolean isOperator(String s) {
		switch (s) {
		case "^": return true;
		case "*": return true;
		case "/": return true;
		case "%": return true;
		case "+": return true;
		case "-": return true;
		case ">": return true;
		case ">=": return true;
		case "<=": return true;
		case "==": return true;
		case "!=": return true;
		case "&&": return true;
		case "||": return true;
		default: return false;
		
		}
	}
	/**
	 * Checks what is held in String to find the precedence of the operator
	 * @param operator: String holding the operator from the expression
	 * @return: int value representing the precedence level of the operator
	 */
	static public int precedence(String operator) {
		if (operator.equals("^"))                           { return 7; }
		if (operator.equals("*") || operator.equals("/") || operator.equals("%")){ return 6; }
		if (operator.equals("+") || operator.equals("-"))   { return 5; }
		if (operator.equals(">") || operator.equals(">="))  { return 4; }
		if (operator.equals("<") || operator.equals("<="))  { return 4; }
		if (operator.equals("==") || operator.equals("!=")) { return 3; }
		if (operator.equals("&&"))                          { return 2; }
		if (operator.equals("||"))                          { return 1; }		
		if (operator.contentEquals("("))					{ return 0; }
		throw new IllegalArgumentException(String.format("Operator %s is not supported.", operator));   // Time complexity: O(n)
        }//End Precedence method
	/**
	 * method to traverse the tree 
	 * @param <T>
	 * @param root: Root of the tree 
	 */
	public static <T> void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data.toString() + ' ');
            inorderTraversal(root.right);
        }
    }
		
	static public <T> int evaluateTree(Node root) {
		//check if node is empty
		
		if((root.left == null) && (root.right == null)) {
			return Integer.parseInt(root.data.toString());

		}//end if for leaf check
		/*node is not leaf, thus should be an operator
		 * gets data from children and performs equation based off them
		 */
		else {
			int left = evaluateTree(root.left);
			int right = evaluateTree(root.right);
			return(equation(left, right, root.data.toString()));
		}
	}//end evaluate tree method
}//end support class 
