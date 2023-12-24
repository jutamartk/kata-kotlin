package com.example.connectdata101

import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*


@Service
class EmployeeService(
    var employeeRepository: EmployeeRepository
) {

    fun createEmployee(request: EmployeeRequest): EmployeeEntity {
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

//    fun updateEmployee(id: Long, request: EmployeeRequest): EmployeeEntity {
//        return employeeRepository.findById(id).map { existingEmployee ->
//            existingEmployee.apply {
//                firstName = request.firstName
//                lastName = request.lastName
//                email = request.email
//                department = request.department
//                hireDate = Instant.parse(request.hireDate)
//                salary = request.salary
//                createDate = Instant.now()
//                updateDate = Instant.now()
//            }
//            employeeRepository.save(existingEmployee)
//        }.orElseGet(error("not found employee id"))
//    }

    fun updateEmployee(id: Long, request: EmployeeRequest): Optional<EmployeeEntity>? {
        if (employeeRepository.findById(id).isPresent) {
            return employeeRepository.findById(id).map { existingEmployee ->
                existingEmployee.let {
                    it.firstName = request.firstName
                    it.lastName = request.lastName
                    it.email = request.email
                    it.department = request.department
                    it.hireDate = Instant.parse(request.hireDate)
                    it.salary = request.salary
                    it.createDate = Instant.now()
                    it.updateDate = Instant.now()
                }
                employeeRepository.save(existingEmployee)
            }
        } else {
            error("not found employee id")
        }
    }
}



