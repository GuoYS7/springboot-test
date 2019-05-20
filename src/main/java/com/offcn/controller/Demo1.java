package com.offcn.controller;

import com.offcn.pojo.Car;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("car")
public class Demo1 {

    @RequestMapping("getAll")
    public List<Car> getAll(){
         List <Car> list = new ArrayList<>();
         list.add(new Car(1,"法拉利",2000.00d,new Date()));
         list.add(new Car(2,"保时捷",2000.00d,new Date()));
         list.add(new Car(3,"拉博基尼",2000.00d,new Date()));

         return list;
    }

    @RequestMapping("hello/{ss}")
    public String hello(@PathVariable(name="ss")String name){
        return "你输入的是："+name;
    }

    @RequestMapping("getOne")
    public Car getOne(@RequestBody Car car){

        return car;
    }

    //时间转换
    @InitBinder
    private void initBinder(ServletRequestDataBinder binder){
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(DateFormat,true));
    }


}
