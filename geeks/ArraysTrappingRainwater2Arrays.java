/*
link-https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1/?category[]=Arrays&category[]=Arrays&difficulty[]=1&page=1&query=category[]Arraysdifficulty[]1page1category[]Arrays
Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
 

Example 1:

Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10
Explanation: 

Example 2:

Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above 
block of height 4 is 3 units and above 
block of height 0 is 7 units. So, the 
total unit of water trapped is 10 units.
Example 3:

Input:
N = 3
arr[] = {6,9,9}
Output:
0
Explanation:
No water will be trapped.

Your Task:
You don'y need to read input or print anything. The task is to complete the function trappingWater() which takes arr and N as input parameters and returns the total amount of water that can be trapped.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
3 <= N <= 107
0 <= Ai <= 108
*/
//sol
class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static int trappingWater(int arr[], int n) { 
        
        // Your code here
        int maxL[]=new int[n];
        int maxR[]=new int[n];
        int maxl=arr[0];
        int maxr=arr[n-1];
        for(int i=0;i<n;i++) {
            maxl=maxl<arr[i]?arr[i]:maxl;
            maxr=maxr<arr[n-i-1]?arr[n-i-1]:maxr;
            maxL[i]=maxl;
            maxR[n-i-1]=maxr;
        }
        int sum=0;
        for(int i=0;i<n;i++) {
            int min=maxL[i]<maxR[i]?maxL[i]:maxR[i];
            sum+=min-arr[i];
        }
        return sum;
    } 
}
