/*
https://practice.geeksforgeeks.org/problems/queries-for-counts-of-multiples-in-an-array4028/1/

Given an array of positive integers and many queries for divisibility. In every query Q[i], we are given an integer K , we need to count all elements in the array which are perfectly divisible by K.

 

Example 1:

Input:
N = 6
A[] = { 2, 4, 9, 15, 21, 20}
M =  3
Q[] = { 2, 3, 5}
Output:
3 3 2
Explanation:
Multiples of '2' in array are:- {2, 4, 20}
Multiples of '3' in array are:- {9, 15, 21}
Multiples of '5' in array are:- {15, 20}
 

Example 2:

Input:
N = 3
A[] = {3, 4, 6}
M = 2
Q[] = {2, 3}
Output:
2 2
Your Task:  
You don't need to read input or print anything. Your task is to complete the function leftElement() which takes the array A[] and its size N, array Q[] and its size M as inputs and returns the array containing the required count for each query Q[i].

 

Expected Time Complexity: O(Mx*log(Mx))
Expected Auxiliary Space: O(Mx)
where Mx is the maximum value in array elements.

 

Constraints:
1<=N,M<=105
1<=A[i],Q[i]<=105


*/
//sol
class Compute {
    
    public long[] countMultiples( long A[], long Q[], long N, long M)
    {
        // Your code goes here
        long max=0;
        HashMap<Long, Integer> map=new HashMap<>();
        for(int i=0;i<(int)N;i++) {
            max=Math.max(A[i], max);
            if(map.get(A[i])==null) map.put(A[i], 1);
            else map.put(A[i], map.get(A[i])+1);
        }
        long ans[]=new long[Q.length];
        for(int i=0;i<(int)M;i++) {
            if(Q[i]>max || Q[i]<1) {
                ans[i]=0;
                continue;
            }
            else {
                for(long n=Q[i];n<=max;n+=Q[i]) {
                    if(map.get(n)!=null) {
                        ans[i]+=map.get(n);
                    }
                }
            }
        }
        return ans;
    }
}
