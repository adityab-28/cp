/*
https://www.youtube.com/watch?v=UOAylfclg14
https://practice.geeksforgeeks.org/problems/game-of-chocolates3554/1/

Bunty and Dolly are playing a game, described as follows.
There are two boxes having A and B number of chocolates respectively. Both can eat L (L ≥ 1) chocolates from any one box or L chocolates from both the boxes in one move. They play the game alternatively and the last one to eat the chocolate will be the winner.
As Bunty wants to impress Dolly, he wants to make Dolly the winner. You have to help Bunty in deciding who should play first. Assume that both the players play optimally.

Example 1:

Input:
A = 1 and B = 2
Output: Bunty
Explanation:
If Bunty starts first, all the next possible state
(0,2), (1,1), (1,0) are wining state for Dolly
Example 2:

Input:
A = 1 and B = 3
Output: Dolly
Your Task:  
You don't need to read input or print anything. Your task is to complete the function solve() which takes the integer A and B as input parameters and returns false if Bunty should play first else returns true.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
0 ≤ a, b ≤ 106
*/
//sol
import math
class Solution:
    def game (self, A, B):
        # code here
        
        if A > B:
            A, B = B, A
        n = int(B-A)
        d=1 + math.sqrt(5)
        d/=2
        d*=n
        temp=int(d)
        if temp == A:
            return 0
        else:
            return 1
