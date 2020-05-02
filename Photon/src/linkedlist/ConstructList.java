package linkedlist;

public class ConstructList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int inputs[]= {1,2,3,4,5,6,7},len=inputs.length;
		
		//construct LinkedList reversely
		Node head = null;
		
		for(int i=len-1;i>=0;i--) {
			head = new Node(inputs[i],head);
		}
		printList(head);
		
		//construct LinkedList from head
		Node head2=new Node(inputs[0]);
		Node curr=head2;
		for(int i=1;i<len;i++) {
			
			Node newNode = new Node();
			
			newNode.data=inputs[i];
			newNode.next=null;
			
			curr.next=newNode;
			curr=newNode;
		}
		printList(head2);
	}

	private static void printList(Node head) {
		// TODO Auto-generated method stub
		
		while(head.next!=null) {
			System.out.print(head.data+" -> ");
			head=head.next;
		}
		System.out.println("null");
	}
}

class Node{
	
	int data;
	Node next;
	
	public Node(int data, Node node) {
		// TODO Auto-generated constructor stub
		this.data=data;
		this.next=node;
	}
	
	public Node(int data) {
		// TODO Auto-generated constructor stub
		this.data=data;
		this.next=null;
	}
	
	public Node() {
		
	}
}