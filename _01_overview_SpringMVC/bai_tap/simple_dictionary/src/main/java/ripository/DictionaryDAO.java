package ripository;

import java.util.HashMap;
import java.util.Map;

public class DictionaryDAO {
    static public Map<String, String> dataDictionarys;
    static {
        dataDictionarys= new HashMap<>();
        dataDictionarys.put("human","con người");
        dataDictionarys.put("student","học sinh");
        dataDictionarys.put("class","lớp học");
        dataDictionarys.put("job","công việc");
    }


}
