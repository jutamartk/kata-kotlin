package com.example.connectdata101

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Date
import java.sql.Timestamp
import java.time.Instant

@Entity(name = "employees")
data class EmployeeEntity(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id:Long = 0,

    var firstName:String,

    var lastName: String,

    var email: String,

    var department: String,

    var hireDate: Instant,

    var salary: Double,

    @CreationTimestamp
    var createDate: Instant,

    @UpdateTimestamp
    var updateDate: Instant
)
