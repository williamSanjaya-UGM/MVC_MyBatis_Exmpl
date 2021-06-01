package com.example.demo.mapper;

import com.example.demo.entity.Employee;
import com.example.demo.entity.ResultInfoLoc;
import com.example.demo.entity.ResultOrderCashier;
import com.example.demo.entity.dto.DetHandleOrder;
import com.example.demo.entity.dto.InventoryInfo;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getAllEmployees();
    void insertEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    Employee findById(int employeeId);
    void updateEmployee(Employee employee);
    List<InventoryInfo> runStoredProcedure(ResultInfoLoc resultInfoLoc);
    List<DetHandleOrder> runStoredProcedure2(ResultOrderCashier resultOrderCashier);
}
