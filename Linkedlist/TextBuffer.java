//Name :- Rohan Ravi Adkine
//PRN :- 123B1B076
//Assignment no. 4

/*
 * function :-
    1.add_at_First
    2.add_at_Last
    3.remove_first
    4.remove_last
    5.remove_search
    6.copy
    7.print
    8.reverse
    9.add_at_position
    10.remove_duplicates
    11.count
 */

import java.util.*;

public class TextBuffer
{
      public class Word
      {
        String data;
        Word next;
        Word prev;

        public Word(String data){
            this.data = data;
            this.next = null;
            this.prev = null;    
        }
      }
      private Word head;
      private int count;
      private Word tail;
      
      public void add_at_First(String data){
        Word newnode = new Word(data);
        count++;
        if(head==null)
        {
          head = tail = newnode;
          return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
        return;
      }
      
      public void add_at_Last(String data)
      {
        Word newnode = new Word(data);
        count++;
        if(head==null)
        {
          head = tail = newnode;
          return;
        }
        Word temp = head;
        while(temp.next != null)
        {
          temp = temp.next;
        }
        tail = temp;
        tail.next = newnode;
        newnode.prev = tail;
        tail = newnode;
        return;
      }

      public void remove_first()
      {
        if(head == null){
          return;
        }
        if(head.next == null)
        {
           head = tail = null;
           count--;
        }
        head = head.next;
        head.prev = null;
        count--;
      }
 
    public void remove_last()
    {
        if(head == null)
        {
        return;
        }
        if(head.next == null)
        {
        head = tail = null;
        count--;
        }
        tail = tail.prev;
        tail.next = null;
        count--;
    }
      
    public void remove_search(String data){
        if(head == null)
        {
            return;
        }
        Word p = head;
        while(p != null)
        {
            if(p.data == data)
            {
                if(head.next == null)
                {
                    head = tail = null;
                    count--;
                    return;
                }
                if(p == head)
                {
                    remove_first();
                }
                if(p == tail)
                {
                    tail = p.prev;
                    p.prev.next = null;
                    count--;
                    return;
                }
                p.prev.next = p.next;
                p.next.prev = p.prev;
                count--; 
                return;
            }
            p=p.next;
        }
    }

    public void reverse()
    {
        Word prev = null;
        Word curr = head;
        Word next;
        
        while(curr != null)
        {
        next = curr.next;
        curr.next = prev;
        curr.prev = next;
        prev = curr;
        curr = next;
        }
        head = prev;
    }

    public void copy(TextBuffer t2)
    {
        if(head == null)
        {
            return;
        }
        Word temp = head;
        while(temp != null)
        {
            t2.add_at_Last(temp.data);
            temp=temp.next;
        }
        return;
    }

    public void add_at_position(int pos, String data) {
        if (pos <= 0) 
        {
            add_at_First(data);
        } 
        else if (pos >= count) 
        {
            add_at_Last(data);
        } 
        else 
        {
            Word newnode = new Word(data);
            Word temp = head;
            for (int i = 0; i < pos - 1; i++) 
            {
                temp = temp.next;
            }
            newnode.next = temp.next;
            newnode.prev = temp;
            if (temp.next != null) 
            {
                temp.next.prev = newnode;
            }
            temp.next = newnode;
            count++;
        }
    }

    public void remove_duplicates() 
    {
        if (head == null) 
        {
            return;
        }
    
        Word current = head;
    
        while (current != null) 
        {
            Word temp = current.next;
            while (temp != null) 
            {
                if (temp.data.equals(current.data)) 
                {
                    Word toRemove = temp;
                    if (temp == tail) 
                    {
                        tail = temp.prev;
                    }
                    if (temp.prev != null) 
                    {
                        temp.prev.next = temp.next;
                    }
                    if (temp.next != null) 
                    {
                        temp.next.prev = temp.prev;
                    }
                    count--;
                }
                temp = temp.next;
            }
            current = current.next;
        }
    }
    
    public void print()
    {
        Word temp = head;
        System.out.print("null <- ");
        while(temp != null)
        {
        System.out.print(temp.data+" <--> ");
        temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[])
    {
        TextBuffer t1 = new TextBuffer();
        t1.remove_search("Rohan");
        t1.print();
        t1.add_at_Last("Rohan Adkine");
        t1.add_at_First("123B1B076");
        t1.add_at_position(2,"PCCOE");
        t1.add_at_First("123B1B076");
        t1.print();
        t1.remove_duplicates();
        t1.print();
        t1.remove_search("Rohan Adkine");
        t1.print();
        t1.reverse();
        t1.print();
        TextBuffer t2 = new TextBuffer();
        t1.copy(t2);
        t2.print();
    }
}
