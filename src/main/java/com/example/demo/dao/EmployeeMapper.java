package com.example.demo.dao;

import com.example.demo.entity.Employee;
import com.example.demo.entity.ResultOrderCashier;
import com.example.demo.entity.dto.DetHandleOrder;
import com.example.demo.entity.dto.InventoryInfo;
import com.example.demo.entity.ResultInfoLoc;
import com.example.demo.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeMapper {

    public List<Employee> getAllEmployees(){
        SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession();
        List<Employee>employeeList=session.selectList("getAllEmployees");
        session.commit();
        session.close();
        return employeeList;
    }

    public void saveEmployee(Employee employee){
        SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("insertEmployee",employee);
        session.commit();
        session.close();
    }

    public void deleteEmployee(int employeeId){
        SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("deleteEmployee",employeeId);
        session.commit();
        session.close();
    }

    public Employee findById(int employeeId){
        SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession();
        Employee employee=(Employee) session.selectOne("findById",employeeId);
        session.commit();
        session.close();
        return employee;
    }

    public void updateEmployee(Employee employee) {
        SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("updateEmployee",employee);
        session.commit();
        session.close();
    }

    public List<InventoryInfo> runStoredProcedure(ResultInfoLoc resultInfoLoc){
        SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession();
        List<InventoryInfo> inventoryList = session.selectList("runStoredProcedure", resultInfoLoc);
        session.commit();
        session.close();
        return inventoryList;
    }

    public List<DetHandleOrder> runStoredProcedure2(ResultOrderCashier resultOrderCashier){
        SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession();
        List<DetHandleOrder> cashierHandleOrder = session.selectList("runStoredProcedure2", resultOrderCashier);
        session.commit();
        session.close();
        return cashierHandleOrder;
    }
}
