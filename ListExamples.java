import java.util.ArrayList;
import java.util.List;

interface StringChecker {
    boolean checkString(String s); 
}

public class ListExamples {

    public static List<String> filter(List<String> list, StringChecker sc) {
        if(sc == null) {
            return list; 
        }
        
        List<String> result = new ArrayList<>();
        for(String s : list) {
            if(sc.checkString(s)) {
                result.add(s); 
            }
        }
        
        return result;
    }

    public static List<String> merge(List<String> list1, List<String> list2) {
        if(list1.isEmpty()) { 
            return list2;
        }
        if(list2.isEmpty()) {
            return list1; 
        }
       
        List<String> result = new ArrayList<>();
        int index1 = 0, index2 = 0;
        
        while(index1 < list1.size() && index2 < list2.size()) {
            int cmp = list1.get(index1).compareTo(list2.get(index2));
            if(cmp < 0) {
                result.add(list1.get(index1++));
            } else {
                result.add(list2.get(index2++)); 
            }
        }
        
        while(index1 < list1.size()) {
            result.add(list1.get(index1++)); 
        }
        while(index2 < list2.size()) {
            result.add(list2.get(index2++));
        }
        
        return result;
    }
    
    public static void mutateList(List<Integer> list) {
        if(list == null) {
            return;
        }
        
        for(int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) * 2);
        }
    }   
}
