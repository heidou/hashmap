package mengka.stack_02;

public class Taa {

	public static void main(String[] args) {
		
		Node aaNode = new Node(1);
		Node bbNode = new Node(2);
		Node ccNode = new Node(3);
		Node ddNode = new Node(4);
		aaNode.setNext(bbNode);
		bbNode.setNext(ccNode);
		ccNode.setNext(ddNode);
		
		Stack stack = new Stack();
		stack.push(aaNode);
		stack.push(bbNode);
		stack.push(ddNode);
		stack.push(ddNode);
		
		Node tmpNode = stack.pop();
		System.out.println(tmpNode.getVal());
		
		while((tmpNode=stack.pop())!=null){
			System.out.println(tmpNode.getVal());	
		}
	}

}
