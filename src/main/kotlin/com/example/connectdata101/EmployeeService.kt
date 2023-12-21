package com.example.connectdata101

import org.springframework.stereotype.Service
import java.time.Instant


@Service
class EmployeeService(
    var employeeRepository: EmployeeRepository
) {

    fun createEmployee(request: EmployeeRequest):EmployeeEntity {
        return employeeRepository.save(
            EmployeeEntity(
                0,
                request.firstName,
                request.lastName,
                request.email,
                request.department,
                Instant.parse(request.hireDate),
                request.salary,
                Instant.now(),
                Instant.now()
            )
        )
    }
    //save employeeEntity to employeeRepository
}

data class EmployeeRequest(

    var firstName:String,

    var lastName: String,

    var email: String,

    var department: String,

    var hireDate: String,

    var salary: Double,
)