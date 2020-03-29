import java.util.Scanner;
import java.util.Arrays;
public class ArrayRotation {
    public static void main(String args[]) {
      int elemCount=0,rotateBy=0;
      System.out.println("Enter number of elements");
      Scanner s=new Scanner(System.in);
      elemCount=s.nextInt();
      rotateBy=s.nextInt();
      System.out.println(elemCount);
      System.out.println(rotateBy);
      
      
      int [] array=new int[elemCount];
      for (int i=0;i<elemCount;i++)
        array[i]=s.nextInt();
      System.out.println(Arrays.toString(array));
      
      // Approach 1 - Rotate one by one - time =(n*r) space=O(1)     
      for(int j=0;j<rotateBy;j++)
      {
        int val=array[0];
        for (int i=1;i<elemCount;i++)
            array[i-1]=array[i];
        array[elemCount-1]=val;
      }
      System.out.println(Arrays.toString(array));
      
      
      //Approcah 2 - Array Juggling - time O(n) space O(1)
      int g=gcd(elemCount,rotateBy);
      for(int i=0;i<g;i++)
      {
          int val=array[i];
          int j=i;
          int k=(j+rotateBy)%elemCount;
          while(i!=k)
          {
                array[j]=array[k] ; 
                j=k;
                k=(j+rotateBy)%elemCount;
          }
          array[j]=val;
      }
      System.out.println(Arrays.toString(array));
      
      //Approach 3 - Block Swap
      int i=rotateBy;
      int j=elemCount-rotateBy;
      int d=rotateBy;
      if(i!=0 && i!=elemCount)
      {
          while(i!=j)
          {
            if(i<j)
            {
                swap(array,d-i,d+j-i,i);
                j-=i;
            }
            else
            {
                swap(array,d-i,d,j);
                i-=j;
            }
          }
          swap(array,d-i,d+j-i,i);
      }
      System.out.println(Arrays.toString(array));
       
    }
    
    static int gcd(int first,int second)
    {
        int rem=first%second;
        while(rem!=0)
        {
            first=second;
            second=rem;
            rem=first%second;
        }
        return second;
    }
    
    static void swap(int array[], int start1, int start2, int count)
    {
        for (int i=0;i<count;i++)
        {
            int temp=array[start1+i];
            array[start1+i]=array[start2+i];
            array[start2+i]=temp;
        }
        
    }
}
