package W1;
import java.util.Map.Entry<K,V>;

public class HashMap {
	for(Map.Entry<String,Integer> entry:wordCount.entrySet()) {
		String word=entry.getKey();
		int count=entry.getValue();
		System.out.println(word+"appears"+count+"times");
	}
}
