package com.example.demo.controller;

import com.example.demo.entity.ResultInfoLoc;
import com.example.demo.entity.ResultOrderCashier;
import com.example.demo.entity.dto.DetHandleOrder;
import com.example.demo.entity.dto.InventoryInfo;
import com.example.demo.mapper.EmployeeMapperImpl;
import com.example.demo.entity.Employee;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    private EmployeeMapperImpl mapper;

    private static final String EMPLOYEE="add-employee";
    private static final String EMPLOYEELIST="list-employees";

    @RequestMapping
    public String index(Model model){
        model.addAttribute("listemployees",mapper.getAllEmployees());
        return EMPLOYEELIST;
    }

    @RequestMapping("/showFormForAdd")
    public String addEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return EMPLOYEE;
    }

    @RequestMapping("/saveProcess")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        if(employee.getId() == null){
            mapper.saveEmployee(employee);
        }else{
            mapper.updateEmployee(employee);
        }
        return "redirect:/";
    }

//    @RequestMapping(value = "/saveProcess",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
//    public Employee saveEmployee(@RequestBody Employee employee){
//        System.out.println(employee);
//        if(employee.getId() == null){
//            mapper.saveEmployee(employee);
//        }
//        return employee;
//    }

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
