package service;

import ripository.DictionaryDAO;

import java.util.Set;

public class DictionaryService {

    static public String search(String searchString) {

        String result="";

                result = DictionaryDAO.dataDictionarys.get(searchString);


        if (result == null ){
            result=" No data like you are looking for ";
        }
        return result;
    }
}
