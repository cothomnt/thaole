package CSD201_AS2_FX11317;

import Stack_Queue.MyLinkedListQueue;

public class MyQueue {
    Node head,tail;

    MyQueue(){
        head = tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    //xoa phan tu o dau
    public Product dequeue() throws Exception{
        if(isEmpty()) throw new Exception();
        Product x = head.getInfo();
        head=head.getNextNode();
        if(head==null) tail=null;
        return(x);
    }

    //them phan tu vao cuoi queue
    void enqueue(Product x){
        if(isEmpty()){
            head = tail = new Node(x);
        } else {
            tail.setNextNode(new Node(x));
            tail = tail.getNextNode();
        }
    }


    @Override
    public String toString() {
        String result = "";
        Node curNode = head;
        while(curNode != null){
            result += curNode.getInfo().toString() + "\n";
//            System.out.print(curNode.getInfo().toString() + "\n");
            curNode = curNode.getNextNode();
        }
        System.out.println();

        return result;
    }
}
