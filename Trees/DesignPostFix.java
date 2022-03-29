//https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/submissions/

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
    String x;
    Node left;
    Node right;
};

class NodeSvc extends Node{
      
    public int evaluate(){
        
        if(this.left == null && this.right == null){
            return Integer.parseInt(x);
        }
        int leftVal = left.evaluate();
        int rightVal = right.evaluate();
    
        if(x.equals("+")){
            return leftVal + rightVal;
        }else if(x.equals("-")){
            return leftVal - rightVal;
        }else if(x.equals("*")){
            return leftVal * rightVal;
        }else if(x.equals("/")){
            return leftVal / rightVal;
        }
        return -1;
    }                     
}
/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<NodeSvc> stack = new Stack<>();
        
        for(String str: postfix){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                if(stack.isEmpty()){
                    return null;
                }else{
                    NodeSvc ele1 = stack.pop();
                    NodeSvc ele2 = stack.pop();
                    NodeSvc root = createNode(str);
                    root.right = ele1;
                    root.left = ele2;
                    stack.push(root);
                }
            }else{
                stack.push(createNode(str));
            }
        }
        return stack.pop();
    }
    
    NodeSvc createNode(String val){
        NodeSvc n = new NodeSvc();
        n.x = val;
        n.left = null;
        n.right = null;
        return n;
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
