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

		public visit(){
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








}