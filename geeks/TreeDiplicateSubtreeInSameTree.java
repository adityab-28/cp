/*
https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1/

Given a binary tree, find out whether it contains a duplicate sub-tree of size two or more, or not.


Example 1 :

Input : 
               1
             /   \ 
           2       3
         /   \       \    
        4     5       2     
                     /  \    
                    4    5
Output : 1
Explanation : 
    2     
  /   \    
 4     5
is the duplicate sub-tree.
Example 2 :

Input : 
               1
             /   \ 
           2       3
Output: 0
Explanation: There is no duplicate sub-tree 
in the given binary tree.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function dupSub() which takes root of the tree as the only arguement and returns 1 if the binary tree contains a duplicate sub-tree of size two or more, else 0.
Note: Two same leaf nodes are not considered as subtree as size of a leaf node is one.


Constraints:
1 ≤ length of string ≤ 100
*/
//sol
class Solution {
   int flag=0;
   Map<String,Integer>mp= new HashMap<>();
   int dupSub(Node root) {
       // code here 
       if(root == null)    return 0;
       find(root);
      return flag;
   }
   String find(Node root){
       if(root==null)return "s";
       String s="";
       s+=root.data;
       s+=find(root.left)+find(root.right);
       if(!mp.containsKey(s)){
           
       if(root.left!=null&&root.right!=null)
        mp.put(s,1);
       }
       else
        flag=1;
       return s;
   }
}
