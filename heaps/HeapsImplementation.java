package heaps;
import java.util.ArrayList;

public class HeapsImplementation {

    ArrayList<Integer> minheap;
    int n;

    public void initializeHeap() {
        this.minheap= new ArrayList<>();
        minheap.add(0);
        this.n=0;
    }

    public void bubbleDown(int index){
        int i=index, j=i*2;
            while(j<minheap.size()){
                if(j<minheap.size()-1 && minheap.get(j+1)<minheap.get(j)){
                    j+=1;
                }

                if(minheap.get(i)>minheap.get(j)){
                    //swap
                    int temp=minheap.get(i);
                    minheap.set(i,minheap.get(j));
                    minheap.set(j,temp);
                    //update i,j
                    i=j;
                    j=i*2;
                }
                else break;
            }
    }

    public void bubbleUp(int index){
         int i=index;
         int val=minheap.get(index);
            while(i>1 && minheap.get(i)<minheap.get(i/2) ){
                minheap.set(i,minheap.get(i/2));
                i=i/2;
            }
            minheap.set(i,val);
    }

    public void insert(int key) {
        minheap.add(key);
        int i=minheap.size()-1;
        while(i>1 && minheap.get(i)<minheap.get(i/2)){
            minheap.set(i,minheap.get(i/2));
            i=i/2;
        }
        minheap.set(i,key);
    }

    public void changeKey(int index, int newVal) {
        minheap.set(index,newVal);
    
        if(newVal<minheap.get(index/2)){
            //bubble up
           bubbleUp(index);
        }
        else{
            //bubble down
            bubbleDown(index);
        }
    }

    public void extractMin() {
        int n=minheap.size();
        if(n<=1) return;
        minheap.set(1,minheap.get(n-1));
        minheap.remove(n-1);
        
        //bubble down
        bubbleDown(1);
    }

    public boolean isEmpty() {
        return minheap.size()<=1;
    }

    public int getMin() {
       return minheap.get(1);
    }

    public int heapSize() {
        return minheap.size()-1;
    }
}




