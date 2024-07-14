package com.app.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {
	
	@Value("${trainer.name}")
	private String trainer;

	@GetMapping("/time")
	public String getTime()
	{
		return "Time on Server "+LocalDateTime.now();
	}
	
	@GetMapping("/info")
	public String getInfo()
	{
		return "Trainer Name = "+trainer;
	}
	
	
	
	
}
