package CSD201_AS2_FX11317;

import Stack_Queue.MyLinkedListStack;

import java.util.ArrayList;

public class MyStack {
    Node head;

    public MyStack(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    //them san pham moi vao stack
    public void push(Product item){
        head = new Node(item,head);
    }

    //lay san pham tren cung ra
    public Product pop(){
        Product pop = null;
        if(isEmpty()){
            System.out.println("Stack is Empty!");
        } else {
            pop = head.getInfo();
            head = head.getNextNode();
        }
        return pop;
    }


    @Override
    public String toString() {
        String result = "";
        Node temp = head;
        ArrayList<Product> tempList = new ArrayList<>();
        while(temp != null){
            // System.out.print(temp.value + " ");
            tempList.add(temp.getInfo());
            temp = temp.getNextNode();
        }
        for (int i = 0; i < tempList.size(); i++) {
            result += tempList.get(i) + "\n";
//            System.out.print(tempList.get(i) + "\n");
        }
//        System.out.println();

        return result;
    }
}
