package com.example.connectdata101

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.Timestamp
import java.time.Instant
import java.util.*


@RestController
@RequestMapping("/employee")
class EmployeeController(var employeeService: EmployeeService) {

    @PostMapping
    fun postEmployee(@RequestBody request:EmployeeRequest):EmployeeEntity{
       return employeeService.createEmployee(request)
    }

    @GetMapping
    fun getAllEmployee():List<EmployeeEntity>{
        return employeeService.getListOfEmployee()
    }

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id:Long):EmployeeEntity{
        return employeeService.employeeRepository.findById(id).get()
    }

    @DeleteMapping("/{id}")
    fun deleteEmployeeById(@PathVariable id:Long):String{
        return employeeService.employeeRepository.deleteById(id).toString()
    }

    @PutMapping("/{id}")
    fun putEmployee(@PathVariable id:Long,
                    @RequestBody request: EmployeeRequest): Optional<EmployeeEntity>? {
        return employeeService.updateEmployee(id, request)
    }

}