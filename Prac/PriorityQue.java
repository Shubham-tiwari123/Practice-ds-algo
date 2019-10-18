package datastructures;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

class Node{
    int data;
    int key;
    
    public Node(int data,int key) {
        this.data = data;
        this.key = key;
    }
    
}

class NodeList{
    int data;
    String list;
    
    public NodeList(int data,String list) {
        this.data = data;
        this.list = list;
    }
    
}
public class PriorityQue {
    
    Scanner s = new Scanner(System.in);
    static int heapArray[];

    public void createMaxHeap(int arr[]) {
        heapArray = arr;
        int lastNonLeafNode = (arr.length/2)-1;
        for(int i=lastNonLeafNode;i>=0;i--){
            buildMax(i);
        }
        System.out.print("\nPrint max heap:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    private void buildMax(int i) {
        int max = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<heapArray.length && heapArray[left]>heapArray[max])
            max=left;
        if(right<heapArray.length && heapArray[right]>heapArray[max])
            max=right;
        if(max!=i){
            int temp = heapArray[i]; 
            heapArray[i] = heapArray[max]; 
            heapArray[max] = temp; 
            buildMax(max);
        }
    }
    
    public int[] createMinHeap(int arr[]) {
        heapArray = arr;
        int lastNonLeafNode = (arr.length/2)-1;
        for(int i=lastNonLeafNode;i>=0;i--){
            buildMin(i);
        }
        return heapArray;
    }
    
    private void buildMin(int i) {
        int min = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<heapArray.length && heapArray[left]<heapArray[min])
            min=left;
        if(right<heapArray.length && heapArray[right]<heapArray[min])
            min=right;
        if(min!=i){
            int temp = heapArray[i]; 
            heapArray[i] = heapArray[min]; 
            heapArray[min] = temp; 
            buildMin(min);
        }
    }
    
    void findLargestMinHeap(int arr[]){
        heapArray = arr;
        int parent = (arr.length-1)/2 - 1;
        int max=Integer.MIN_VALUE;
        for(int i=parent;i<arr.length;i++)
            if(arr[i]>max)
                max=arr[i];
        
        System.out.print("\nMax:"+max);
    }
    
    public int[] deleteElement(int key,int arr[]){
        int i=0;
        while(arr[i]!=key)
            i++;
        arr[i]=arr[arr.length-1];
        return createMinHeap(arr);
    }
    
    void mergeTwoMaxHeap(int arr1[],int arr2[]){
        int res[] = new int[arr1.length+arr2.length-1];
        int count=0;
        for(int i=0;i<arr1.length;i++){
            res[count] = arr1[i];
            count++;
        }
        int i=0;
        while(i<arr2.length-1){
            res[count] = arr2[i];
            count++;
            i++;
        }
        createMinHeap(res);
        System.out.print("\nafter merge\n");
        for(i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
        
    }
    
    int[] deleteMin(int arr[]){
        arr[0] = arr[arr.length-1];
        arr[arr.length-1]=Integer.MAX_VALUE;
        return createMinHeap(arr);
    }
    
    void createPriorityQueue(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(17);
        minHeap.add(13);
        minHeap.add(6);
        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(2);
        minHeap.add(5);
        System.out.print("\nminheap:"+minHeap);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        maxHeap.add(11);
        maxHeap.add(15);
        maxHeap.add(12);
        maxHeap.add(16);
        maxHeap.add(17);
        maxHeap.add(14);
        maxHeap.add(13);
        
        System.out.print("\nMax heap:"+maxHeap);
    }
    
    void stackUsingPQ(){
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return -Integer.compare(o1.key, o2.key);
            }
        });
        System.out.print("\nEnter stack len:");
        int len = s.nextInt();
        for(int i=0;i<len;i++){
            System.out.print("Enter element:");
            int element = s.nextInt();
            Node n = new Node(element, i);
            minHeap.add(n);
        }
        System.out.print("Print stack:\n");
        for(int i=0;i<len;i++){
            Node n = minHeap.poll();
            System.out.println(n.data);
        }
    }
    
    void queueUsingPq(){
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.key, o2.key);
            }
        });
        System.out.print("\nEnter queue len:");
        int len = s.nextInt();
        for(int i=0;i<len;i++){
            System.out.print("Enter element:");
            int element = s.nextInt();
            Node n = new Node(element, i);
            minHeap.add(n);
        }
        System.out.print("Print Queue:\n");
        for(int i=0;i<len;i++){
            Node n = minHeap.poll();
            System.out.println(n.data);
        }
    }
    
    void megreKsortedList(){
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(8);
        list1.add(16);
        list1.add(24);
        list1.add(32);
        list1.add(40);
        
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(6);
        list2.add(12);
        list2.add(18);
        list2.add(24);
        list2.add(30);
        
        LinkedList<Integer> list3 = new LinkedList<>();
        list3.add(20);
        list3.add(25);
        list3.add(30);
        list3.add(35);
        list3.add(40);
        
        int size = list1.size()+list2.size()+list3.size();
        int noOfList=3;
        LinkedList<Integer> res = new LinkedList<>();
        PriorityQueue<NodeList> pq = new PriorityQueue<>(new Comparator<NodeList>() {
            @Override
            public int compare(NodeList o1, NodeList o2) {
                return Integer.compare(o1.data, o2.data);
            }
        });
        NodeList n1 = new NodeList(list1.poll(), "l1");
        NodeList n2 = new NodeList(list2.poll(), "l2");
        NodeList n3 = new NodeList(list3.poll(), "l3");
        pq.add(n1);
        pq.add(n2);
        pq.add(n3);
        
        while(res.size()!=size){
            NodeList n = pq.poll();
            res.add(n.data);
            if(n.list.equals("l1") && !list1.isEmpty()){
                n1 = new NodeList(list1.poll(), "l1");
                pq.add(n1);
            }
            else if(n.list.equals("l2") && !list2.isEmpty()){
                n1 = new NodeList(list2.poll(), "l2");
                pq.add(n1);
            }
            else if(n.list.equals("l3") && !list3.isEmpty()){
                n1 = new NodeList(list3.poll(), "l3");
                pq.add(n1);
            }
        }
        
        System.out.print("\nresult:"+res);
    }
    
    void findLargestPair(){
        //find largest pair (A[i],B[j])
        LinkedList<Integer> A = new LinkedList<>();
        LinkedList<Integer> B = new LinkedList<>();
        for(int i=0;i<6;i++){
            Random r = new Random();
            Random r1 = new Random();
            int num1 = r.nextInt(50);
            int num2 = r1.nextInt(40);
            A.add(num1);
            B.add(num2);
        }
        /*System.out.print("\nListA:"+A);
        System.out.print("\nListB:"+B);*/
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        for(int i=0;i<6;i++){
            pq1.add(A.poll());
            pq2.add(B.poll());
        }
        System.out.println("\nLargest pair:"+pq1.poll()+","+pq2.poll());
    }
}