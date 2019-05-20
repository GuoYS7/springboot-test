package com.offcn.controller;

import com.offcn.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {
    List<User> userList = new ArrayList<>();

    //查询全部数据
    @GetMapping("/")
    @ApiOperation(value = "查询全部的数据",notes = "查询宣布的用户信息")
    public List findUsers(){
        return userList;
    }

    //向聚合中增加数据
    @PostMapping("/")
    @ApiOperation(value = "增加一条数据",notes = "向数据库中增加一条用户信息")
    @ApiImplicitParam(name = "user",value = "用户的实体：user",required = true,dataType = "User",paramType = "123")
    public String createUser(@RequestBody User user){
        userList.add(user);
        return "success";
    }

    //查询一条数据
    @GetMapping("/{id}")
    @ApiOperation(value = "查询一条数据",notes = "根据数据的id 查询一条用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Long")
    public User findOne(@PathVariable("id") Long id){
        for(User user : userList){
            if(user.getId() == id){
                return user;
            }
        }

        return null;
    }

    //修改数据
    @PutMapping("")
    @ApiOperation(value = "修改一条数据",notes = "根据主键修改数据库中一条用户信息")
    @ApiImplicitParam(name = "user",value = "用户的实体：user",required = true,dataType = "User")
    public String updateUser(@RequestBody User user){

        for(User user2 : userList){
            if(user2.getId() == user.getId()){
                user2.setUsername(user.getUsername());
                user2.setAge(user.getAge());
            }
        }

        return "success";
    }

    //删除数据
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除一条数据",notes = "根据数据的id 删除一条用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Long")
    public String deleteUser(@PathVariable("id") Long id){
        for(User user : userList){
            if(user.getId() == id){
                userList.remove(user);
                return "success";
            }
        }
        return "error";
    }
}
