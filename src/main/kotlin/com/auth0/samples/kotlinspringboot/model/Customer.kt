package com.auth0.samples.kotlinspringboot.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue

@Entity
class Customer(
		// this is the primary constructor
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		var id: Long = 0,
		var firstName: String = "",
		var lastName: String = ""
)

