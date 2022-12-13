package ch5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class 엔지니어대한민국 {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(5,6);
        graph.addEdge(5,7);
        graph.addEdge(6,8);
        graph.dfs();
    }

}

class Graph{
    class Node{
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        public Node(int data) {
            this.data = data;
            this.marked = false;
            this.adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;

    public Graph(int size) {
        this.nodes = new Node[size];
        for(int i = 0; i< size;i++){
            nodes[i] = new Node(i);
        }
    }
    void addEdge(int i1,int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }
    void dfs(){
        dfs(0);
    }
    void dfs(int index){
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()){
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if(n.marked == false){
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void visit(Node n){
        System.out.print(n.data +" ");
    }
}
