package com.auth0.samples.kotlinspringboot.persistence

import com.auth0.samples.kotlinspringboot.model.Customer
import org.springframework.data.repository.CrudRepository

// this interface has everything we need to interact with the HSQLDB in-memory database that our project has
interface CustomerRepository : CrudRepository<Customer, Long>

