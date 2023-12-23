package com.example.connectdata101

import org.springframework.stereotype.Service
import java.sql.Timestamp
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

    fun getListOfEmployee(): List<EmployeeEntity> {
        return employeeRepository.findAll()
    }

//    fun updateEmployee(id:Long, request: EmployeeRequest): EmployeeEntity{
//       return employeeRepository.findById(id).map { data -> {
//           data.firstName = request.firstName,
//           data.lastName = request.lastName,
//           data.email = request.email,
//           data.department = request.department,
//           data.salary = request.salary,
//           data.hireDate = Timestamp,
//
//
//
//       }}
}


