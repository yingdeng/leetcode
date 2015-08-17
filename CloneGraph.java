/*
Clone Graph

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

/*
 * Definition for undirected graph.
 */

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>(); // BFS用的queue
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>(); // Hashtable<node, clonedNode> 放原始node和其复制品 
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label); // Copy the node.label to a newHead
        queue.add(node); //添加入队列 
        map.put(node, newHead); // 把根节点和其复制品放入map
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll(); // 当前处理对象
            for (UndirectedGraphNode newNode : curNode.neighbors) { // 对每一个neighbor进行判断，因为有的neighbor已经被复制，有的没有  
                if (!map.containsKey(newNode)) {  // 如果该neighbor没有被复制过，则新建cpNode
                    UndirectedGraphNode cpNode = new UndirectedGraphNode(newNode.label); 
                    map.get(curNode).neighbors.add(cpNode);
                    map.put(newNode, cpNode);
                    queue.add(newNode); // 并且添加到队列里为了将来的遍历
                }
                else { // 之前已经被复制过的neighbor  
                    UndirectedGraphNode neighborClone = map.get(curNode); // 就直接从ht里取出neighborClone 
                    neighborClone.neighbors.add(map.get(newNode)); // 给curClone添加复制的neighbor
                }
            }
        }
        return newHead;
    }
}