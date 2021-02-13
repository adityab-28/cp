/*
In the game of Restricted Pacman, an infinite linear path is given. Pacman has to start at position 0 and eat as many candies as possible. In one move he can only jump a distance of either M or N.  If M and N are coprime numbers, find how many candies will be left on the board after the game is over.
Note: The result is always finite as after a point X every index in the infinite path can be visited. 

Example 1:

Input: M = 2, N = 5
Output: 2
Explanation: From index 0, the indices that 
can be visited are
0 + 2 = 2
0 + 2 + 2 = 4
0 + 5 = 5
0 + 2 + 2 + 2 = 6
0 + 2 + 5 = 7
0 + 2 + 2 + 2 + 2 = 8
0 + 2 + 2 + 5 = 9
0 + 5 + 5 = 10
and so on.
1 and 3 are the only indices that cannot be 
visited. Therefore the candies at these two 
positions will be left on the board. 

Example 2:

Input: M = 2, N = 7
Output: 3 
Example 3:

Input: M = 25, N = 7
Output: 72
Your Task:  
You don't need to read input or print anything. Complete the function candies() which take M and N as input parameters and return the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ M, N ≤ 500

Hint:Find the largest index that can’t be obtained using any combination of M & N using Frobenius Number which defines X = (M * N) – M – N. 
Add X to a queue. X is the largest index than cannot be visited so every index greater than X need not be checked. Now add X-M and X-N to the queue and so on. 
*/
//sol
class Solution{
    static int candies(int m, int n)
    {
        // Your code goes here 
        int x=m*n-m-n;
        Queue<Integer> q=new LinkedList<>();
        q.add(x);
        int c=0;
        Set<Integer> visited=new HashSet<>();
        
        while(!q.isEmpty()) {
            int p=q.poll();
            if(visited.contains(p)) continue;  //hashsets are defined by hashing functions hence their .contains() has a O(n) time complexity
            visited.add(p);
            if(p>m) {
                q.add(p-m);
            }
            if(p>n) {
                q.add(p-n);
            }
            c++;
        }
        return c;
    }
}
