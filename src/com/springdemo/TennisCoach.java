package com.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">>TennisCoach indside default constructor");
	}
	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">>Tenniscoach: inside of doMystartupStuff()");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanStuff() {
		System.out.println(">>TennisCoach: inside of doMyCleanupStuff()");
	}
	
	
	/*
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {	
		System.out.println(">>TennisCoach indside serFortuneService() method");
		fortuneService= theFortuneService;
	}*/
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}*/
	
	@Override
	public String getDailyWorkout() {
		
		return "practice your backend volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
