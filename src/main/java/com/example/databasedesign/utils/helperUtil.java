package com.example.databasedesign.utils;

import com.example.databasedesign.bean.Classroom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class helperUtil {

    public static Map<String, Object> pageHelper(List list, Integer pIndex, Integer pSize){
        Map<String, Object> res = new HashMap<>();
        res.put("pagetotal", list.size());
        if(pIndex != null && pSize != null){
            list = list.subList((pIndex - 1) * pSize, Math.min(pIndex * pSize, list.size()));
        }
        res.put("data", list);
        return res;
    }
}
