package com.example.databasedesign.controller;
import com.example.databasedesign.bean.Student;
import com.example.databasedesign.service.ManagerService;
import com.example.databasedesign.service.SelectorService;
import com.example.databasedesign.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private SelectorService selectorService;


    @RequestMapping("/login/find_user")
    public Result userLogin(@RequestBody Map<String, Object> params){
        System.out.println("User Login");
        System.out.println(params);
        try{
            if(params.get("method") != null){
                List<Map<String, Object>> result;
                result = selectorService.selectUserByNameAndPassword((Integer)params.get("method"),(String) params.get("username"),
                        (String)params.get("password"));
                System.out.println(result);
                if(result.size() != 0){
                    return Result.ok();
                }else{
                    return Result.error("wrong username or password");
                }
            }
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
        return null;
    }
}
