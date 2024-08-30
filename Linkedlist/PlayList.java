import java.util.*;

public class PlayList 
{
    public class Song
    {
        int sid;
        String title;
        String artist;
        Song next;

        public Song(int sid,String title,String artist)
        {
            this.sid = sid;
            this.title = title;
            this.artist = artist;
            this.next = null;
        }
    }

    public static Song head;
    public static int count;
    public static Song tail;

    public void add_Song_at_Beginning(int sid,String title,String artist)
    {
       Song newsong = new Song(sid,title,artist);
       count++;
       if(head == null)
       {
        head = tail = newsong;
        return;
       }
       newsong.next = head;
       head = newsong;
       return;
    }

    public void add_Song_at_Last(int sid,String title,String artist)
    {
       Song newsong = new Song(sid,title,artist);
       count++;
       if(head == null)
       {
        head = tail = newsong;
        return;
       }
       tail.next = newsong;
       tail = newsong;
       return;
    }

    public void add_Song_at_position(int idx,int sid,String title,String artist)
    {
       Song newsong = new Song(sid,title,artist);
       count++;
       if(head == null)
       {
        head = tail = newsong;
        return;
       }
       int i=0;
       Song temp= head;
       while(i < idx -1)
       {
        temp = temp.next;
        i++;
       }
       newsong.next = temp.next;
       temp.next=newsong;
       return;
    }

     public int Search_id(int key)  
    {
        Song temp=head;
        int i=0;
        while(temp!=null){
            if(temp.sid==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
 
    public static void removeFirst_Song() 
    {
        if(count==0){
            System.out.println("PlayList is Empty");
            return;
        }
        else if(count==1){
            head=tail=null;
            count=0;
            return;
        }
        else{
            head=head.next;
            count--;
            return;
        }
    }

    public static void removeLast_Song()  
    {
        if(count==0){
            System.out.println("PlayList is Empty");
            return;
        }
        else if(count==1){
            head=tail=null;
            count=0;
            return;
        }
        else{
            Song prev=head;
            for(int i=0;i<count-2;i++){
                prev=prev.next;
            }
            prev.next=null;
            tail=prev;
            count--;
            return;
        }
    }
    public int Search_title(String key)  
    {
        Song temp=head;
        int i=0;
        while(temp!=null){
            if(temp.title==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    public void Search_artist(String key)  
    {
        Song temp=head;
        int i=0;
        while(temp!=null){
            if(temp.artist==key){
                System.out.println("The song artist is present in PlayList at position "+i+".");
            }
            temp=temp.next;
            i++;
        }
        return ;
    }

    public static void reverse_playlist()
    {
        Song prev = null;
        Song curr = head;
        Song next;
        while(curr != null)
        {
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return;
    }

    public static void playall_songs()
    {
        if(head==null)
        {
            System.out.println("PlayList is Empty");
            return;
        }
        Song temp= head;
        while(temp!=null)
        {
            System.out.println("Song id is:-" +temp.sid +","+"Song title is:-"+temp.title +","+"Song artist is:-"+temp.artist +" -> ");
            temp=temp.next;
        }
        System.out.println("null");
        return;
    }
    public static void main(String args[])
    {
        PlayList p1 = new PlayList();
        p1.add_Song_at_Beginning(101, "Deva Deva","Arjit Singh");
        p1.add_Song_at_Beginning(100, "faded", "Alan Walker");
        p1.add_Song_at_Last(103, "kesariya", "Arjit Singh");
        p1.add_Song_at_position(2, 102, "DarkSide", "Alan Walker");
        System.out.println("This PlayList name P1 Contains "+p1.count+" Songs.");
        p1.playall_songs();
        System.out.println("The song id is present in playList at position "+ p1.Search_id(101)+".");
        System.out.println("The song title is present in playList at position"+ p1.Search_title("faded")+".");
        p1.Search_artist("Arjit Singh");
        p1.removeFirst_Song();
        p1.removeLast_Song();
        p1.playall_songs();
        p1.reverse_playlist();
        p1.playall_songs();
    }
}