import java.io.*;
import java.util.*;

public class Tree {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int eraseNode = Integer.parseInt(br.readLine());
        int[] nodeNum = new int[n];
        boolean[] isLeaf = new boolean[n];
        ArrayList<LinkedList<Integer>> nodes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            nodeNum[i] = Integer.parseInt(arr[i]);
            isLeaf[i] = true;
            nodes.add(new LinkedList<Integer>());
        }
        
        for(int i = 0; i < n; i++){
            if(nodeNum[i] != -1){
                nodes.get(nodeNum[i]).add(i);
                isLeaf[nodeNum[i]] = false;
            }
        }
        
        if(nodeNum[eraseNode] != -1 && nodes.get(nodeNum[eraseNode]).size() == 1)
        	isLeaf[nodeNum[eraseNode]] = true;
        removeNodes(nodes, eraseNode, isLeaf);
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(isLeaf[i])
                count++;
        }
        
        System.out.println(count);
    }
	
	private static void removeNodes(ArrayList<LinkedList<Integer>> nodes, int eraseNode, boolean[] isLeaf) {
		isLeaf[eraseNode] = false;
		
		while(!nodes.get(eraseNode).isEmpty()) {
			int child = nodes.get(eraseNode).poll();
			removeNodes(nodes, child, isLeaf);
		}
	}

}
