package com.example.demo.mapper;

import com.example.demo.entity.Employee;
import com.example.demo.entity.ResultInfoLoc;
import com.example.demo.entity.ResultOrderCashier;
import com.example.demo.entity.dto.DetHandleOrder;
import com.example.demo.entity.dto.InventoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeMapperImpl {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployees(){
        return employeeMapper.getAllEmployees();
    }

    public void saveEmployee(Employee employee){
        employeeMapper.insertEmployee(employee);
    }

    public void deleteEmployee(int employeeId){
        employeeMapper.deleteEmployee(employeeId);
    }

    public Employee findById(int employeeId){
        return employeeMapper.findById(employeeId);
    }

    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    public List<InventoryInfo> runStoredProcedure(ResultInfoLoc resultInfoLoc){
        return employeeMapper.runStoredProcedure(resultInfoLoc);
    }

    public List<DetHandleOrder> runStoredProcedure2(ResultOrderCashier resultOrderCashier){
        return employeeMapper.runStoredProcedure2(resultOrderCashier);
    }
}
