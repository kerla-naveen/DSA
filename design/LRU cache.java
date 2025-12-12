// User function Template for Java

class LinkedList<T>{
    Node head;
    Node tail;
    int size;
    
    class Node{
        T ele;
        Node prev;
        Node next;
        
        
        Node(T ele){
            this.ele=ele;
            this.next=null;
            this.prev=null;
        }
    }
        
    LinkedList(){
        this.head=new Node(null);
        this.tail=new Node(null);
        head.next=tail;
        tail.prev=head;
        size=0;
    }
    
    void addNodeToHead(Node node){
        node.next=head.next;
        head.next=node;
        
        node.next.prev=node;
        node.prev=head;
        
        size++;
    }
    
    Node addEleToHead(T ele){
        Node newNode=new Node(ele);
        addNodeToHead(newNode);
    return newNode;
    }
    
    void remove(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;
        
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        
        size--;
    }
    
    Node removeLastNode(){
        if(size>0){
            Node LastNode=tail.prev;
            remove(LastNode);
            return LastNode;
        }
    return null;
    }
    
}

class Solution {
    static int pageFaults(int N, int C, int pages[]) {
        // code here
        LinkedList<Integer> cache= new LinkedList<>();
        HashMap<Integer, LinkedList<Integer>.Node> mp= new HashMap<>();
        
        int pageFault=0;
        for(int page : pages){
            if(mp.containsKey(page)){
                cache.remove(mp.get(page));
                cache.addNodeToHead(mp.get(page));
            }
            else{
                pageFault++;
               LinkedList<Integer>.Node newNode= cache.addEleToHead(page);
                mp.put(page,newNode);
                if(cache.size>C){
                    //remove least recently used
                    LinkedList<Integer>.Node last=cache.removeLastNode();
                    mp.remove(last.ele);
                }
            }
        }
        
    return pageFault;
    }
}