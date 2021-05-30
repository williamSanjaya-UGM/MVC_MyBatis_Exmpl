package com.example.demo.controller;

import com.example.demo.dao.EmployeeMapper;
import com.example.demo.entity.Employee;
import com.example.demo.entity.ResultOrderCashier;
import com.example.demo.entity.dto.DetHandleOrder;
import com.example.demo.entity.dto.InventoryInfo;
import com.example.demo.entity.ResultInfoLoc;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    private EmployeeMapper mapper;

    @RequestMapping
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("list-employees");
        mv.addObject("listemployees",mapper.getAllEmployees());
        return mv;
    }

    @RequestMapping("/showFormForAddEmployee")
    public ModelAndView showForm(){
        ModelAndView mv = new ModelAndView("add-employee");
        mv.addObject("employee",new Employee());
        return mv;
    }

    @RequestMapping("/saveProcess")
    public String saveProcess(@ModelAttribute("employee") Employee employee){
        if(employee.getId()==null){
            //save operation
            mapper.saveEmployee(employee);
        } else {
            //update operation
            mapper.updateEmployee(employee);
        }
        return "redirect:/";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId){
        mapper.deleteEmployee(employeeId);
        return "redirect:/";
    }

    @RequestMapping("/editEmployee")
    public ModelAndView editEmployee(@RequestParam("employeeId") int employeeId){
        ModelAndView mv = new ModelAndView("add-employee");
        Employee employee= mapper.findById(employeeId);
        mv.addObject("employee",employee);
        return mv;
    }

    @RequestMapping("/check-inventory")
    public ModelAndView checkInfoForm(){
        ModelAndView mv = new ModelAndView("check-inventory");
        mv.addObject("inventoryInfoLoc",new ResultInfoLoc());
        return mv;
    }

    @RequestMapping("/saveProcedure")
    public ModelAndView callStoredProcedure(@ModelAttribute("inventoryInfoLoc") ResultInfoLoc resultInfoLoc){
        ModelAndView mv = new ModelAndView("check-inventory");
        mapper.runStoredProcedure(resultInfoLoc);
        List<InventoryInfo> infoCur = resultInfoLoc.getInfoCur();
        mv.addObject("inventoryInfoList",infoCur);
        return mv;
    }

    @RequestMapping(value = "/checkOrderCashierPayment",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Return all cashier nama ,food name, and price by inputted transactionId")
    public List<DetHandleOrder> callStoredProcedure2(
            @ApiParam(value = "Please enter transactionId you want to search by",required = true)
            @RequestBody ResultOrderCashier resultOrderCashier){
        mapper.runStoredProcedure2(resultOrderCashier);
        try{
            ObjectMapper om = new ObjectMapper();
            ObjectWriter writer = om.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("C:/Users/LENOVO/Desktop/Test/logs.txt"),resultOrderCashier.getListOrderBy());
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
        return resultOrderCashier.getListOrderBy();
    }
}
