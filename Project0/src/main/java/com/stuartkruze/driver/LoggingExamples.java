package com.stuartkruze.driver;

import org.apache.log4j.Logger;

public class LoggingExamples {

	final static Logger log = Logger.getLogger(LoggingExamples.class);
	
	public static void main(String[] args) {
		System.out.println("Regular ole print statement");
		//Taking a look at different logging levels
		log.trace("trace message - very fine-grained");
		log.debug("this statement should be useful for debugging the application");
		log.info("informational message use this level");
		log.warn("something bad potentially could happen");
		log.error("something went wrong");
		log.fatal("program died");
		new LoggingExamples().verifyExceptions();
	}
	
	@SuppressWarnings("unused")
	public void verifyExceptions() {
		if(10 == 20) {
			log.error("What are you talking about?");
		} else {
			log.info("Worked as expected");
		}
	}

}
