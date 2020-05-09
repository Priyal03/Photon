package linkedlist;

public class SplitList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int keys[] = { 1, 2, 3, 4, 5, 6 };

		Node currNode = null;

		for (int i = keys.length - 1; i >= 0; i--) {
			currNode = new Node(keys[i], currNode);
		}
		printList(currNode);

		splitList(currNode);

		splitListOrderly(currNode);
	}

	private static void splitListOrderly(Node head) {
		// TODO Auto-generated method stub

		Node aDummy = new Node();
		Node aTail = aDummy; // points to the last node in 'a'
		aDummy.next = null;

		Node bDummy = new Node();
		Node bTail = bDummy; // points to the last node in 'b'
		bDummy.next = null;

		Node current = head;

		while (current != null) {
			// add at 'a' tail

			Node newNode = current;
			current = current.next;

			newNode.next = aTail.next;
			aTail.next = newNode;

			aTail = aTail.next; // advance the 'a' tail
			if (current != null) {
				// add at 'b' tail

				newNode = current;
				current = current.next;

				newNode.next = bTail.next;
				bTail.next = newNode;

				bTail = bTail.next; // advance the 'b' tail
			}
		}
	}

	// the idea is to take head element and point the data element's next to that
	// head thus moving the head in the end
	// and at last copying the node to the head so that it moves further. and that's
	// why you will get resultant list in reverse order.
	private static void splitList(Node head) {
		// TODO Auto-generated method stub

		Node a = null, b = null, current = head;

		while (current != null) {

			Node temp = current;
			current = current.next;

			temp.next = a;
			a = temp;

			System.out.print(a.data + " ->a ");

			if (current != null) {

				temp = current;
				current = current.next;

				temp.next = b;
				b = temp;

				System.out.print(b.data + " ->b ");
			}

		}

		printList(a);
		printList(b);
	}

	private static void printList(Node head) {
		// TODO Auto-generated method stub

		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}

}
