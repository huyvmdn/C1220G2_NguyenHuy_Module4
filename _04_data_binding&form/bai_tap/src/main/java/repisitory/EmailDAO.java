package repisitory;

import model.Email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailDAO {

    static public Map<Integer, String> listLanguages;
    static public List<Integer> listSizePage;
    static {
        listLanguages= new HashMap<>();
        listLanguages.put(1,"English");
        listLanguages.put(2,"Vietnamese");
        listLanguages.put(3,"Japanese");
        listLanguages.put(4,"Chinese");
        listSizePage=new ArrayList<>();
        listSizePage.add(5);
        listSizePage.add(10);
        listSizePage.add(15);
        listSizePage.add(20);
        listSizePage.add(50);
        listSizePage.add(100);
    }


}
