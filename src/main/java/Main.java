

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static List<int[]> evaluate(Map<Integer, String> list, int target) {
		
		List<int[]> result = new ArrayList<>(); 
		for(Iterator<Map.Entry<Integer, String>> it = list.entrySet().iterator(); it.hasNext(); ) {
		    Map.Entry<Integer, String> entry = it.next();
		    
		    int evaluate = Integer.parseInt(entry.getValue());
		    Integer sub = target - evaluate;//12-5 = 7
		    
		    if(list.containsValue(sub.toString())){
				System.out.println( entry.getValue() + ", "+ sub);
				result.add(new int[] {evaluate, sub});
			}
		    it.remove(); //additional instruction to remove the current evaluation
		}
		
		return result;
	}
	public static void main(String[] args) throws IOException {
		
		System.out.println("Enter the numbers with a comma separated:");
		
		// Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
        // Reading data using readLine
        String numbers = reader.readLine();//1,9,5,0,20,-4,12,16,7
        
        
		//Map<Integer, Integer> map = new TreeMap<Integer, Integer>();//treeMap is more efficient
		String[] list = numbers.split(",");
		Map<Integer, String> map = IntStream.range(0, list.length).boxed()
			    .collect(Collectors.toMap(i ->i, i -> list[i]));
		evaluate(map, 12);
		
	}

}
