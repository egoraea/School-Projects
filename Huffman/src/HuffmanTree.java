import java.util.HashMap;
import java.util.Map;


public class HuffmanTree {
	private TreeNode start;
	public HuffmanTree(PriorityQueue pq){
		while(pq.size()>=2){
			TreeNode left = pq.dequeue();
			TreeNode right = pq.dequeue();
			pq.enqueue(new TreeNode(-1,left.myValue+right.myValue,left,right));
		}
		start = pq.dequeue();
	}
	public Map<Integer,String> getValues(){
		HashMap<Integer,String> result = new HashMap<Integer,String>();
		valuesHelper(result,start,"");
		return result;
	}
	private void valuesHelper(Map<Integer,String> map,TreeNode curr,String s){
		if (curr.isLeaf()){
			map.put(curr.getValue(), s);
		} else {
			valuesHelper(map,curr.getLeft(),s+"0");
			valuesHelper(map,curr.getLeft(),s+"1");
		}
	}
}
