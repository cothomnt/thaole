package CSD201_AS2_FX11317;

import java.util.Scanner;

public class MyList{
    private Node head, tail;
    Scanner sc = new Scanner(System.in);

    public MyList() {

    }

    public MyList(Node head, Node tail) {
        //nut head va tail mac dinh ban dau la null
        this.head = this.tail = null;
    }

    //Checking if this list is empty
    public boolean isEmpty() {
        return (head == null) && (tail == null);
    }

    //tinh do dai cua list
    public int length() {
        Node curNode = head;
        int length = 0;
        //duyet qua linked list qua moi node thi tang leng len 1
        while(curNode != null){
            length++;
            curNode = curNode.getNextNode();
        }

        return length;
    }

    // them sp vao cuoi list
    public void insertToTail(Product item){
        Node newNode = new Node(item);

        // tim vi tri cuoi
        Node curNode = head;
        if(head == null){
            this.head = newNode;
        } else{
            //tim den vi tri cuoi cua node
            while(curNode.getNextNode() != null){
                curNode = curNode.getNextNode();
            }
            //them newNode vao cuoi node
            curNode.setNextNode(newNode);
        }
    }

    // them sp vao dau node
    public void insertToHead(Product item) {
        Node newNode = new Node(item);
        //con tro nut new chi vao head
        newNode.setNextNode(head);
        this.head = newNode;
    }

    // them phan tu theo index
    public void insertAfterPosition(int position, Product item) {
        if(position == 0){
            insertToHead(item);
        } else{
            //tim vi tri can them
            Node newNode = new Node(item);
            Node curNode = head;
            int count = 0;
            //xet vong lap chay tu dau den cuoi node
            while(curNode.getNextNode() != null){
                count++;
                //neu bien count bang position -> vi tri can them vao
                if(count == position){
                    // thuc hien them
                    newNode.setNextNode(curNode.getNextNode());
                    curNode.setNextNode(newNode);
                }
                curNode = curNode.getNextNode();
            }
        }
    }

    //tim so luong cua sp dau tien cua node
    public int searchQuantity(){
        return head.getInfo().getQuantity();
    }

    //xoa sp cuoi cua node
    public void deleteTail() {
        if(isEmpty()){
            System.out.println("List is Empty");
        } else{
            //xd last and previous
            Node lastNode = head;
            Node preNode = null;
            while(lastNode.getNextNode() != null){
                preNode = lastNode;
                lastNode = lastNode.getNextNode();
            }
            // thuc hien xoa
            preNode.setNextNode(lastNode.getNextNode());
        }

    }

    // xoa phan tu dua tren id
    public void deleteElement() {
        //nhap id ptu can xoa
        System.out.print("Input the bcode to delete= ");
        String name = sc.next();
        if(isEmpty()){
            System.out.println("List is Empty");
        } else {
            // xd vi tri can xoa
            Node curNode = head;
            Node preNode = null;
            while(curNode.getNextNode() != null){
                preNode = curNode;
                curNode = curNode.getNextNode();
                //thuc hien xoa khi gap id cua node trung vs id can xoa
                if(curNode.getInfo().getBcode().contains(name)){
                    preNode.setNextNode(curNode.getNextNode());
                }
            }
        }
        System.out.println("Deleted!");
    }

    //tim phan tu theo id
    public String searchByCode(String bcode) {
        //nhap id can tim
        Node curNode = head;

        //duyet list neu gap Node co id giong thi in ra thong tin node
        while(curNode != null){
            if(curNode.getInfo().getBcode().contentEquals(bcode)){
                return "Result: " +curNode.getInfo().toString() + "\n";

            }
            curNode = curNode.getNextNode();
        }
        return "-1\n";
    }

    // sx list theo id
    public void sortByID(){
        Node curNode = head;
//        while(curNode != null){
//            if(head == null){
//                return;
//            } else{
                while(curNode != null){
                    Node nextNode = curNode.getNextNode();
                    Product temp;
                    while(nextNode != null){
                        if(curNode.getInfo().getBcode().compareTo(nextNode.getInfo().getBcode()) > 0){
                            temp = curNode.getInfo();
                            curNode.setInfo(nextNode.getInfo());
                            nextNode.setInfo(temp);
                        }
                        nextNode = nextNode.getNextNode();
                    }
                    curNode = curNode.getNextNode();
                }
//            }
//        }
    }

    // dung de quy thuc hien chuyen doi quantity cua sp dau tien sang he nhi phan
    public void convertToBinary(int number){
        int remainder;
        if(number <= 1){
            System.out.print(number);
            return;
        }
        //remainder la so du khi chia 2
        remainder = number % 2;
        convertToBinary(number >> 1);
        System.out.print(remainder);
    }


    public void clear() {
        head = tail = null;
    }

    @Override
    public String toString() {
        String result = "";
        Node curNode = head;
        while(curNode != null){
            result += curNode.getInfo().toString() + "\n";
            curNode = curNode.getNextNode();
        }
        return result;
    }
}
