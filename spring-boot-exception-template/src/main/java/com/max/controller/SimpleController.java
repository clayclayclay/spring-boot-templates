
package com.max.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.max.exception.SimpleException;

@RestController
public class SimpleController
{

	@GetMapping("/entities/{id}")
	public String getEntity(@PathVariable String id)
	{

		if (!(id.equals("id")))
		{
			throw new SimpleException("the id is invalid");
		}

		return "get entity successfully";
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Request Body is null")
	@ExceptionHandler(NullPointerException.class)
	@PostMapping("/entities")
	public String createEntity(@RequestBody String requestBody)
	{
		throw new NullPointerException("Request Body is nul");
	}
}
