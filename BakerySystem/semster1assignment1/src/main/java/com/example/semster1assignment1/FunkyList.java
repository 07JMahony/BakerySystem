package com.example.semster1assignment1;
public class FunkyList<N> {

    public FunkyNode<N> head = null,last=null;

    public void add(N c) {                                                //Add element to head of list
        FunkyNode<N> temp=new FunkyNode<>();
        temp.setContents(c);
        if(head==null) head=temp;
        else last.next=temp;                                              //using last makes the elements add from the back of the list
        last=temp;                                                        //this makes the lists print the right way around
    }

    public void reset() {                                                 //Sets the head to null resetting the list
        head=null;
    }
    //Inner class approach.
    public class FunkyNode<N> {
        public FunkyNode<N> next=null;
        public N contents;                                                  //ADT reference

        public N getContents(){
            return contents;
        }
        public void setContents(N c) {
            contents=c;
        }
    }
    public void delete(int d) {
        FunkyNode<N> temp = head;
        int i = 1;

        while (i < d && temp != null) {                                              // while i is less than d and temp is not equal to null
            temp = temp.next;                                                        // set temp to the next node
            i++;
        }
        if (d == 0) {
            head = head.next;
        }
        else if (temp != null && temp.next != null) {                                // if temp is not equal to null and temp.next is not equal to null
            temp.next = temp.next.next;                                              //set the 2nd node to be the 3rd node i.e. relinks the list
        }
    }

    @Override
    public String toString() {
        return "FunkyList{" +
                "head=" + head +
                '}';
    }
}







