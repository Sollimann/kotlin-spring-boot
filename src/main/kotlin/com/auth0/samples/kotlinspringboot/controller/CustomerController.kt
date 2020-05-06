package com.auth0.samples.kotlinspringboot.controller

import com.auth0.samples.kotlinspringboot.model.Customer
import com.auth0.samples.kotlinspringboot.persistence.CustomerRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController

// annotation declares that all endpoints in this class will have the /customers prefix
@RequestMapping("customers")

class CustomerController(val repository: CustomerRepository) {

	// annotation defines 'findAll' as the method responsible for handling HTTP Get requests to /customer
	@GetMapping
	fun findAll() = repository.findAll()

	/* annotation defines 'addCustomer' as the method responsible for handling HTTP Post requests to /customer.
	   Also, this method accepts a JSON version of customer and deserialize it to our Customer class automatically.
	* */
	@PostMapping
	fun addCustomer(@RequestBody customer: Customer) = repository.save(customer)

	/* annotation defines 'updateCustomer' as the method responsible for handling HTTP put requests to /customers.
	*  This method also accepts a customer as the body of the request. The difference between the Put and Post is
	*  that put expects the request path to have an {id} of the Customer to be updated.
	* */
	@PutMapping("/{id}")
	fun updateCustomer(@PathVariable id: Long, @RequestBody customer: Customer) {
		assert(customer.id == id)
		repository.save(customer)
	}

	/* annotation defines 'removeCustomer' as the method responsible for handling HTTP Delete requests to /customers.
	 {id}, in this case, defines the id of the customer to be deleted.
	* */
	@DeleteMapping("/{id}")
	fun removeCustomer(@PathVariable id: Long) = repository.delete(id)


	/* annotation defines 'getById' as the method responsible for handling HTTP Get requests to /customer/{id}, where
	   {id} defines which customer will be serialized as a response.
	* */
	@GetMapping("/{id}")
	fun getById(@PathVariable id: Long) = repository.findOne(id)
}
