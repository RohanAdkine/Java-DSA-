import java.util.*;

public class Question_1 
{
    public static int Remove_dup(int arr[]){
        int n=arr.length;
        int j=0;
        int i=1;
        while(i< n){
            if(arr[j] != arr[i]){
                j++;
                arr[j]=arr[i];
            }
            i++;
        }       
        return j+1; 
    }
    public static void main(String args[]){
        int arr[] ={1,1,2,2,3,4,5};
        System.out.println(Remove_dup(arr));
    }
}
