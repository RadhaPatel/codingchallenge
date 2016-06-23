public class TreeAndGraphs{

	public class Tree{
		public Node root; 
	}
	public class Node{
		public boolean visited; 
		public int data; 

		List<Node> adjacent = new List<Node>(); 

		public Node(){

		}

		public void visit(){
			this.visited = true; 
		}

	}

	public class TreeNode{
		int data; 
		TreeNode right; 
		TreeNode left; 

		public TreeNode(int data){
			this.data = data; 
			left = null; 
			right = null; 
		}
	}
	public static void main(String[] args){

	}

	
	public static void depthFirst(Node root){
		if(root == null)
			return; 
		visit(root);  
		for(Node n: root.adjacent){
			if(n.visited != true){
				depthFirst(n); 
			}
		}
	}

	public static void breathFirst(Node root){
		Queque q = new Queque(); 
		root.visit(); 
		q.enqueue(root); 
		
		while(!q.isEmpty()){
			Node r = q.dequeue(); 
			visit(r); 
			for(Node n: r.adjacent){
				if(n.visited == false){
					visit(n); 
					q.enqueue(n); 
				}
			}
		}
	}

	/*
		4.1 Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes. 

		Method: Basically: Use BFS 
	*/
		boolean route(Graph g, Node s, Node e){
			Queque q = new Queque(); 
			s.visit(); 
			q.enqueue(s); 

			while(!q.isEmpty()){
				Node r = q.dequeque(); 
				for(Node n: r.adjacent){
					if(!n.visited){ 
						if(n == e){
							return true; 
						}
						else{
							n.visit();
							q.enqueue(n); 
						}
					}
				}
				// FORGOT THIS PART: 
				r.visit(); 
			}
			return false; 
		}

	/*
		4.2 Minimal Tree: given a sorted array with unique number - create a BST with minimal height 

		Method: Divide the array in half each time; first look at the left side (divide in half) middle value is the root (next child)
		do the same with the right side
	*/ 
	 public TreeNode minTree(int[] arr){
	 	minTree(arr, 0, arr.length - 1); 
	 }

	 public TreeNode minTree(int[] arr, int first, int last){
	 	if(end < start)
	 		return null; 
	 	
	 	int middle = (last + first) / 2; 
	 	TreeNode root = new Node(arr[middle]); 
	 	root.left = minTree(arr, 0, middle - 1); 
	 	root.right = minTree(arr, middle + 1, last); 
	 	return root; 
	 }

	 /*
	 	4.3 List of Depth: Given a BST create a linked list of all the nodes at each depth. 
	 	If the tree has D levels - then there will be D linked lists

	 	Method: BFS - each search out should create a new list 
	 */
	 public List<LinkedList<Integer>> depthList(TreeNode root){
	 	List<LinkedList<Integer>> mList = new List<LinkedList<Integer>>(); 

	 	depthList(mList, root, 1); 
	 	return mList; 
	 }

	 public void depthList(List<LinkedList<Integer>> masterList, TreeNode root, int level){
	 	if(root == null){
	 		return; 
	 	}
	 	LinkedList<Integer> dlist = null; 
	 	if(masterList.size() == level){
	 		dlist = new LinkedList<Integer>();  
	 		masterList.add(dlist); 
	 	} 
	 	else {
	 		dlist = masterList.get(level); 
	 	}
	 	dlist.add(root); 

	 	depthList(masterList, root.right, level + 1); 
	 	depthList(masterList, root.left, level + 1); 
	 }

	 /*
	 4.4 Check Balanced: Check if a BST is balanced (meaning that the height of the subtrees of any node never differ by more than one)
	 */
	 public boolean checkBalanced(TreeNode root){
	 	if(root == null)
	 		return; 
	 	int heightDiff = Math.abs(getHeight(root.right) - getHeight(root.left)) + 1 ; 
	 	if(heightDiff > 1){
	 		return false; 
	 	}
	 	return checkBalanced(root.left) && checkBalanced(root.right); 

	 }

	 public int getHeight(Node root){
	 	if(root == null)
	 		return -1; 
	 	return Math.max(getHeight(root.right), getHeight(root.left)); 
	 }


	 /*
	 4.5 Valid BST: Implement a function to check if a BT is a BST

	 METHOD: look on the left and check if its less than root, look on the right and check if tis greater than roote
	 */
	 public boolean isValidBST(TreeNode root){
	 	if(root == null)
	 		return true; 

	 	if(root.left != null){
	 		if(root.left.data < root.data){
	 			return isValidBST(root.left); 
	 		}
	 		else{
	 			return false; 
	 		}
	 	}

	 	if(root.right != null){
	 		if(root.right.data >= root.data){
	 			return isValidBST(root.right); 
	 		} else{
	 			return false; 
	 		}
	 	}

	 	return true; 

	 }

	 //Book Soulution for 4.45 - vat?
	 public boolen isValidBST_Book(TreeNode root){
	 	if(root == null)
	 		return true; 

	 	if(!isValidBST_Book(root.left)){
	 		return false;
	 	}

	 	if(last_data != null && root.data <= last_data){
	 		return false;
	 	}

	 	last_data = n.data; 

	 	if(!isValidBST_Book(root.right)){
	 		return false; 
	 	}

	 	return true; 
	 }


}