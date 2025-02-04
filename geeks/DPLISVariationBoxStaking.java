/*
You are given a set of N types of rectangular 3-D boxes, where the ith box has height h, width w and length l. You task is to create a stack of boxes which is as tall as possible, but you can only stack a box on top of another box if the dimensions of the 2-D base of the lower box are each strictly larger than those of the 2-D base of the higher box. Of course, you can rotate a box so that any side functions as its base.It is also allowable to use multiple instances of the same type of box. You task is to complete the function maxHeight which returns the height of the highest possible stack so formed.
 

Note: 
Base of the lower box should be strictly larger than that of the new box we're going to place. This is in terms of both length and width, not just in terms of area. So, two boxes with same base cannot be placed one over the other.

 

Example 1:

Input:
n = 4
height[] = {4,1,4,10}
width[] = {6,2,5,12}
length[] = {7,3,6,32}
Output: 60
Explanation: One way of placing the boxes is
as follows in the bottom to top manner:
(Denoting the boxes in (l, w, h) manner)
(12, 32, 10) (10, 12, 32) (6, 7, 4) 
(5, 6, 4) (4, 5, 6) (2, 3, 1) (1, 2, 3)
Hence, the total height of this stack is
10 + 32 + 4 + 4 + 6 + 1 + 3 = 60.
No other combination of boxes produces a
height greater than this.
Example 2:

Input:
n = 3
height[] = {1,4,3}
width[] = {2,5,4}
length[] = {3,6,1}
Output: 15
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxHeight() which takes three arrays height[], width[], length[], and N as a number of boxes and returns the highest possible stack height which could be formed.


Expected Time Complexity : O(N*N)
Expected Auxiliary Space: O(N)


Constraints:
1<= N <=100
1<= l,w,h <=100
*/
//sol
class Solution 
{
    static class Box implements Comparable<Box>{
    
        int h, w, d, area;
    
        public Box(int h, int w, int d) {
            this.h = h;
            this.w = w;
            this.d = d;
        }
        
        @Override
        public int compareTo(Box o) {
            return o.area-this.area;
        }
    }
    static int maxStackHeight( Box arr[], int n){
        
        Box[] rot = new Box[n*3];
        
        for(int i = 0;i < n;i++){
            Box box = arr[i];
            
            rot[3*i] = new Box(box.h, Math.max(box.w,box.d), 
                                    Math.min(box.w,box.d));
            
            rot[3*i + 1] = new Box(box.w, Math.max(box.h,box.d), 
                                       Math.min(box.h,box.d));
            
            rot[3*i + 2] = new Box(box.d, Math.max(box.w,box.h),
                                       Math.min(box.w,box.h));
        }
        
        for(int i = 0; i < rot.length; i++)
            rot[i].area = rot[i].w * rot[i].d;
        
        Arrays.sort(rot);
        
        int count = 3 * n;
        
        int msh[] = new int[count];
        for (int i = 0; i < count; i++ )
            msh[i] = rot[i].h;
        
        for(int i = 0; i < count; i++){
            msh[i] = 0;
            Box box = rot[i];
            int val = 0;
            
            for(int j = 0; j < i; j++){
                Box prevBox = rot[j];
                if(box.w < prevBox.w && box.d < prevBox.d){
                    val = Math.max(val, msh[j]);
                }
            }
            msh[i] = val + box.h;
        }
        
        int max = -1;
        
        for(int i = 0; i < count; i++){
            max = Math.max(max, msh[i]);
        }
        
        return max;
    }

    public static int maxHeight(int height[], int width[], int length[], int n)
   {
       // your code here4
       Box arr[]=new Box[n];
       
       for(int i=0;i<n;i++) {
           arr[i]=new Box(height[i], width[i], length[i]);
       }
       
       return(maxStackHeight(arr, n));
   }
}
'
 
 /*
 https://practice.geeksforgeeks.org/problems/beautiful-subsequence5222/1/
 
 Nowadays Babul is solving problems on sub-sequence. He is struck with a problem in which he has to find the longest sub-sequence in an array A of size  N such that for all (i,j) where i!=j either A[i] divides A[j] or vice versa. If no such sub-sequence exists then print -1. Help him to accomplish this task.

Example 1:

â€‹Input : arr[ ] = {5, 3, 1, 4, 7}
Output : 2
Explanation:
Longest Sub Sequence are {5,1} , {4,1}, 
{3,1} etc. So, size is 2.

Example 2:

Input : arr[ ] = {2, 4, 6, 1, 3, 11} 
Output : 3 


Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function longest_Subsequence() that takes an array (arr), sizeOfArray (n), and return the length of the longest subsequence of the array. The driver code takes care of the printing.

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N).


Constraints :
2 ≤ N ≤ 2000
1 ≤ A[i] ≤ 105
 */
 //sol
 class Solution{
    // Function for finding maximum and value pair
    public static int longest_Subsequence (int arr[], int n) {
        //Complete the function
        Arrays.sort(arr);
        int [] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++)
            for(int j=0;j<i;j++)
                if(arr[i]%arr[j]==0 || arr[j]%arr[i]==0)
                    dp[i]=Integer.max(dp[i],dp[j]+1);
        int ans=1;
        for(int i:dp)
            ans=Integer.max(ans,i);
        if(ans==1)
            ans=-1;
        return ans;
    }
}
