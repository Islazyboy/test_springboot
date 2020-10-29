package com.usian.controller;

import com.github.pagehelper.PageInfo;
import com.usian.entity.Emp;
import com.usian.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.Action;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping("/goShow")
    public String goShow(Emp emp, @RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "2")Integer pageSize, Model model){
        PageInfo<Emp> page = empService.selectAll(emp,pageNum,pageSize);
        model.addAttribute("page", page);
        model.addAttribute("emp",emp);
        return "show";
    }

    @RequestMapping("/goAdd")
    public String goAdd(){
        return "add";
    }

    @RequestMapping("/addEmp")
    public String addEmp(Emp emp){
        empService.insert(emp);
        return "redirect:goShow";
    }

    @RequestMapping("/delById")
    public String delById(Integer id){
        empService.delById(id);
        return "redirect:goShow";
    }

    @RequestMapping("/findById")
    public String findById(Integer id,Model model){
        Emp emp = empService.queryById(id);
        model.addAttribute("emp",emp);
        return "update";
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(Emp emp){
        empService.update(emp);
        return "redirect:goShow";
    }
}
