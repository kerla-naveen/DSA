package heaps;


 class Heap {
    static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void insert(int[] heap,int n){

        int i=n;
        int temp=heap[n];
        while(i>1 && temp>heap[i/2]){
            //place the parent at the child palce
            heap[i]=heap[i/2];
            i=i/2;
        }
        heap[i]=temp;
    }

    static int delete(int[] heap, int n){
        int x=heap[1];
        heap[1]=heap[n];
        n--;
        int i=1, j=2;
        while(j<=n){
            if(heap[j+1]>heap[j]) j+=1;

            if(heap[i]<heap[j]){
                swap(i,j,heap);
                i=j;
                j=i*2;
            }
            else break;
        }
        heap[n+1]=x;
    return x;
    }

    public static void main(String[] args) {
        int[] heap= new int[]{0,22,25,30,35,40,10,15,5};

        for(int i=2;i<=8;i++){
            insert(heap,i);
        }

        for(int i=1;i<=8;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
        for(int i=8;i>1;i--){
            delete(heap, i);
        }

        //after deleteing the whole created heap, the arr look like
        for(int i=1;i<=8;i++){
            System.out.print(heap[i]+" ");
        }
    }    
}
