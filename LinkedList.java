public class LinkedList{
	
	public insertNth(Node head, int data, int position){
		while(poistion != 0){
			head = head.next; 
			position--; 
		}
		
		int old_data = head.data; 
		Node n = new Node(old_data); 
		head.data = data; 
		n.next = head.next; 
		head.next = n; 
	}

	/*
		2.1 Remove Duplicates in LinkedList - with buffer
	*/
	public static void removeDuplicates(Node head){
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>(); 
		Node current = head;
		Node prev = null 
		while(current != null){
			if(map.containsKey(current.data)){
				prev.next = current.next;  

			} else{
				map.put(current.data); 
				prev = current; 
			}
			current = current.next; 
		}
	}

	public static void removeDuplicatesNoBuffer(Node head){
		Node current = head; 
		while(current != null){
			Node runner = current; 
			while(runner.next != null){
				if(current.data == runner.data){
					runner.data = runner.next.data; 
					runner.next = runner.next.next;  
				}
				runner = runner.next; 
			}
			current = current.next; 
		}
	}

	/*
		2.2 Return kth to last: Implement an algo to find the keth to last element of a linked list
	*/
	public static void findKthtoLast(Node head, int k){
		Node current = head; 
		Node result = head; 
		int index = 0; 

		while(current != null){
			current = current.next; 
			if(index++ > k){
				result = result.next; 
			}
		}
		return result.data;
	}

	/*
		2.3 Delete give node from linkedList
	*/
	public static boolean deleteMiddleNode(Node n){
		if(n == null || n.next == null)
			return false; 
		n.data = n.next.data; 
		n.next = n.next.next; 
		return true; 
	}

	/*
		2.4 Partition: All nodes less than X to the left of X, nodes greater should be to the right of X. 
	*/
	public static partition(Node node, int x){
		Node head = node; 
		Node tail = node; 

		while(node != null){
			Node next = node.next; 
			if(node.data < x){
				node.next = head; 
				head = node; 
			}
			else{
				tail.next = node; 
				tail = node; 
			}

			node = next; 
		}
		tail.next = null; 
		return head; 
	}

	/*
		2.5 Sum Lists: Given 2 linked lists in backwards order - sum them up! 
	*/
	public static findSum(Node num1, Node num2, int carry){
		if(num1 == null && num2 == null && carry == 0)
			return null; 
		
		Node result = new Node(); 
		int value = carry; 

		if(num1 != null){
			value += num1.data; 
		}

		if(num2!= null){
			value += num2.data; 
		}

		result.data = value % 10; 

		if(num1 !=null || num2 != null){
			Node more = findSum((num1 !=null) ? null : num1.next, 
								(num2 !=null) ? null : num2.next, 
							     value >= 10 ? 1 : 0 ); 

		result.next = more; 
		}
		return result; 
	}

	/*
		2.6 Check if LinkedList is a palidrome
		METHOD: Reverse and copy the new linked list and compare it!
	*/
	public static boolean isPalidrome(Node head){
		Node cloneNode = reverseNew(head); 
		return isEqual(head, cloneNode); 
	}

	public static Node reverseNew(Node head){
		Node prev = null; 
		while(head != null){
			Node n = new Node(head.data); 
			n.next = prev; 
			prev = n; 
			head = head.next; 
		}
		return prev; 
	}

	public static boolean isEqual(Node n1, Node n2){
		while(n1 != null && n2 != null){
			if(n1.data == n2.data){
				n1 = n1.next; 
				n2 = n2.next; 
			}
			else{
				return false; 
			}
		}
		return true; 
	}

	/*
		2.7 Intersection: Given 2 linkedlists determine if they interset (point to the same node in the list)
	*/
	public static Node intersection(Node l1, Node l2){
		int size1 = 1; 
		int size2 = 1; 

		Node tail1 = null; 
		Node tail2 = null; 

		Node current = l1; 
		while(current.next != null){
			size1++; 
			current = current.next; 
		}
		tail1 = current; 

		current = l2; 
		while(current.next != null){
			size2++; 
			current = current.next; 
		}
		tail2 = current; 

		// No intersection
		if(tail1 != tail2){
			return null; 
		}

		Node shorter = size1 < size2 ? l1 : l2; 
		Node longer = size1 < size2 ? l2 : l1; 

		// Make them the same size 
		int difference = longer - shorter; 
		while(difference > 0 && longer != null){
			longer = longer.next; 
			difference--; 
		}

		while(shorter != longer{
			shorter = shorter.next; 
			longer = longer.next; 
		}

		return shorter; 
	}










}