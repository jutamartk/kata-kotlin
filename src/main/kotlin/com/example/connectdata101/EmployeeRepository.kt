package com.example.connectdata101

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface EmployeeRepository: JpaRepository<EmployeeEntity, Number> {
}