package com.example.connectdata101

import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant


@RestController
class EmployeeController(var employeeService: EmployeeService) {

    @PostMapping("/employee")
    fun postEmployee(@RequestBody request:EmployeeRequest):EmployeeEntity{
       return employeeService.createEmployee(request)
    }


}