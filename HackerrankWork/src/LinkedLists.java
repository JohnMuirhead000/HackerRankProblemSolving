import java.util.*;

public class LinkedLists {

    //Takes in a single node and wants to print out every element of LinkedList
    //"Print the Elements of a Linked List" - EASY
    static void printLinkedList(SinglyLinkedListNode head) {
        while (true) {
            if (head == null) return;
            System.out.println(head.data);
            head = head.next;
        }
    }
    
    //as the name describes:
    //"Insert a node at the head of a linked list" - EASY
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode list, int data) {

        SinglyLinkedListNode sol = new SinglyLinkedListNode(data);
        sol.next = list;
        return sol;
    }


    //as the name describes:
    //"Insert a Node at the Tail of a Linked List" - EASY
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode newNode =  new SinglyLinkedListNode(data);

        if (head == null){
            head = newNode;
            return head;
        }

        SinglyLinkedListNode current =  head;

        while (current.next != null){
            current = current.next;
        }

        current.next = newNode;
        return head;
    }
    //MASSIVE MASSIVE confusion here.  When I create a new node why on planet earth will updating that one change the
    //head? well the answer is because each node refers to the same exact next node.  While the head is copied, the thing
    //it points to is the exact same. Confused me at first.




    //as name describes
    //"Insert a node at a specific position in a linked list" - EASY
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        SinglyLinkedListNode current = head;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (position == 0){
            newNode.next = head;
            return newNode;
        }
        int counter = 0;
        while (true){
            if (counter == position-1){

                newNode.next = current.next;
                current.next = newNode;
                break;

            } else {
                current = current.next;
                counter++;
            }
        }
        return head;
    }

    //Im extremely glad I took the time to understand the last one before moving on to this one/


    //as name describes
    //"Delete a Node" - EASY
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {

        SinglyLinkedListNode current = head;

        if (position == 0){
            return head.next;
        }

        int counter = 0;
        while (true){
            if (counter == position-1){

                current.next = current.next.next;
                break;

            } else {
                current = current.next;
                counter++;
            }
        }
        return head;
    }
    //Recycled code form the last problem - made slight altercations



    //As name describes
    //"Print in Reverse" - EASY
    static void reversePrint(SinglyLinkedListNode head) {

        if (head == null){return;}

        ArrayList<Integer> copy = new ArrayList<>();

        while (!(head == null)){
            copy.add(head.data);
            head = head.next;
        }

        for (int i = copy.size()-1; i >= 0; i --){
            System.out.println(copy.get(i));
        }
    }



    //Returns a linked list which is the opposite direction of given linked list
    //"Reverse a Linked List" - EASY
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {

        ArrayList<Integer> copy = new ArrayList<>();

        while (!(head == null)){
            copy.add(head.data);
            head = head.next;
        }

        SinglyLinkedListNode newHead = new SinglyLinkedListNode(copy.get(copy.size()-1));
        SinglyLinkedListNode current = new SinglyLinkedListNode(copy.get(copy.size()-2));
        newHead.next = current;

        for (int i = copy.size()-3; i >= 0; i--){
            current.next = new SinglyLinkedListNode(copy.get(i));
            current = current.next;
        }

        return newHead;
    }
    //I have no idea if I did this in an even somewhat optimal way but the code works.



    //returns 1 if two linked lists are the same, 0 otherwise
    //"Compare two linked lists" - EASY
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2){

        if (head1 == null && head2 == null){return true;}

        while (head1 != null && head2 != null){

            if (head1.data != head2.data){
                return false;
            }

            if (head1.next == null && head2.next == null){
                return true;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        return false;
    }
    //Note, I had a solution I taught was good.  It worked on all test cases except 1 (runtime error).
    //This solution I got from online.


    //merges two already ordered linked list lists into one linked list
    //"Merge two sorted linked lists" - EASY
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (head1 == null && head2 == null)return null;
        if (head1 == null)return head2;
        if (head2 == null)return head1;

        SinglyLinkedListNode finalAnswer = null;

        if (head1.data < head2.data){
             finalAnswer = head1;
             head1 = head1.next;
        } else {
            finalAnswer = head2;
            head2 = head2.next;
        }

        SinglyLinkedListNode current = finalAnswer;

        while (head1 != null && head2 != null){

            if (head1.data < head2.data){
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 == null){
            current.next = head2;
        } else {
            current.next = head1;
        }

        return finalAnswer;
    }
    //Note: I did write this solution 95% independently and it did not work and so looked up the solution online.
    //It happened to be nearly identical to one on youtube but for a few minor changes that were making mine not work


    //gives a pointer to a head node and an index and wants to get the data at the index counting backwards
    //from the tail of the node (the tail is 0, the second to last is 1, etcc)
    //"Get Node Value" - EASY
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {


        ArrayList<Integer> copy = new ArrayList<>();

        while (!(head == null)){
            copy.add(head.data);
            head = head.next;
        }

        SinglyLinkedListNode newHead = new SinglyLinkedListNode(copy.get(copy.size()-1));
        SinglyLinkedListNode current = new SinglyLinkedListNode(copy.get(copy.size()-2));
        newHead.next = current;

        for (int i = copy.size()-3; i >= 0; i--){
            current.next = new SinglyLinkedListNode(copy.get(i));
            current = current.next;
        }

        int counter = 0;

        while (counter != positionFromTail){
            newHead = newHead.next;
            counter ++;
        }
        return newHead.data;
    }
    //Did I seriously just copy and paste the 'Reverse a Linked List" code and then treat it as if it told me
    //to get the node at a certain index? I seriously just did. Seemed resourceful to me.

    //given a sorted linked list, delete all of the duplicates in it
    //"Delete duplicate-value nodes from a sorted linked list" - EASY
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {

        if (head == null)return null;

        SinglyLinkedListNode finalAnswer = head;

        while (head.next != null){

            if (head.data == head.next.data){
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return finalAnswer;

    }
    //Ok, linked list referencing might be the most confusing concept in all of java

    //Given a linked list, determine if it loops back on itself
    //"Cycle Detection" - MEDIUM
    static boolean hasCycle(SinglyLinkedListNode head) {

        if (head == null)return false;

        SinglyLinkedListNode tortoise = head;
        SinglyLinkedListNode hare = head.next;

        while (hare != null && hare.next != null){
            if (tortoise == hare){
                return true;
            }
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return false;
    }
    //Initially, I had a solution that computed correctly but gave a runtime error.  It worked by creating a
    //new SinglyLinkedListNode and, as it cycles down head, checking if the head is pointed to from the new
    // SinglyLinkedListNode.  If it was it returned true; if it was null it returned false. If it was neither
    //it added the current head to the new SinglyLinkedListNode list.
    //For this solution I used the internet and learned about the tortoise and hare algorithm.



    //Given two head pointers, and assuming they will merge, find and return the value of the node the merge at
    //"Find Merge Point of Two Lists" - EASY
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode a = head1;
        SinglyLinkedListNode b = head2;

        while (a != b){

            if (a.next == null){
                a = head2;
            } else {
                a = a.next;
            }

            if (b.next == null){
                b = head1;
            } else {
                b = b.next;
            }
        }
        return a.data;
    }
    //Had to use the googles to understand this one


    //As name describes
    //"Inserting a Node Into a Sorted Doubly Linked List" - EASY
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (head == null)return newNode;

        DoublyLinkedListNode current = head;
        DoublyLinkedListNode parent = null;

        while (current != null){

            if (current.data >= data){

                if (parent == null) {
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                    return head;

                }

                    parent.next = newNode;
                    newNode.prev = parent;
                    newNode.next = current;
                   if (current.prev != null) current.prev = newNode;
                    return head;

            }
            parent = current;
            current = current.next;
        }

        parent.next = newNode;
        newNode.prev = parent;
        return head;
    }

    //As name describes
    //"Reverse a doubly linked list" - EASY
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

        DoublyLinkedListNode temp = head;

        while (temp.next != null){
            temp = temp.next;
        }

        DoublyLinkedListNode sol = temp;
        DoublyLinkedListNode TempSol = temp;


        while (TempSol != null){
            TempSol.next = temp.prev;
            TempSol.prev = temp.next;

            TempSol = TempSol.next;
            temp = temp.prev;
        }
        return sol;
    }
    //The classes and stuff that make these functions function.

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

}










