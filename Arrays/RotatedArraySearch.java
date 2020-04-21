import java.util.Scanner;
import java.util.Arrays;
public class RotatedArraySearch {
    public static void main(String args[]) {
      int elemCount=0,rotateBy=0;
      System.out.println("Enter number of elements");
      Scanner s=new Scanner(System.in);
      elemCount=s.nextInt();
      System.out.println("Enter element to search");
      rotateBy=s.nextInt();
      System.out.println(elemCount);
      System.out.println(rotateBy);
      
      
      int [] array=new int[elemCount];
      for (int i=0;i<elemCount;i++)
        array[i]=s.nextInt();
      System.out.println(Arrays.toString(array));

      int pivotIndex=pivot(array,0,elemCount-1);
      if(pivotIndex==-1)
        binarySearch(array,0,elemCount-1,rotateBy);
      else{
            if(array[0]<=rotateBy && rotateBy<=array[pivotIndex])
                System.out.println(binarySearch(array,0,pivotIndex,rotateBy));
            else
                System.out.println(binarySearch(array,pivotIndex+1,elemCount-1,rotateBy));
        }

    }
    
    static int pivot(int array[],int start ,int end)
    {
        //System.out.println(start +" " + end);
        if(start>end)
            return -1;
        
        if(start==end)
            return start;
        
        int mid=(start+end)/2;
        if(array[mid]>array[mid+1])
            return mid;
            
        if(array[start]<array[mid])
            return pivot(array,mid+1,end);
        else
            return pivot(array,start,mid-1);
    }
    
    static int binarySearch(int array[],int start,int end,int val)
    {
        if(start>end)
            return -1;
        int mid=(start+end)/2;
        if(array[mid]==val)
            return mid;
        if(array[mid]<val)
            end=mid-1;
        else
            start=mid-1;
            
        return binarySearch(array,start,end,val);
    }
    
}
