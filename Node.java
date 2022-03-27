package CSD201_AS2_FX11317;

public class Node{
    private Product info;
    private Node nextNode;

    public Node() {

    }

    public Node(Product info){
        this(info,null);
    }

    public Node(Product info, Node nexNode) {
        this.info = info;
        this.nextNode = nexNode;
    }


    @Override

    public String toString() {
        return this.info.toString() + "\n";
    }


    public Product getInfo() {
        return info;
    }

    public void setInfo(Product info) {
        this.info = info;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}


