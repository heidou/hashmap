package mengka.queue_02;

class Queue{
	
    Node first, last;

    public void enqueue(Node node){
        if(first == null){
            first = node;
            last = first;
        }else{
            last.next = node;
            last = node;
        }
    }

    public Node dequeue(){
        if(first == null){
            return null;
        }else{
            Node temp = new Node(first.val);
            first = first.next;
            return temp;
        }   
    }
}
