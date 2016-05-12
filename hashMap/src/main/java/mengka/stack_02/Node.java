package mengka.stack_02;

public class Node {
	int val;
	Node next;

	Node(int x) {
		val = x;
		next = null;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
