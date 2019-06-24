package com.dc.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;


public class Log {

	//Initialise Log4j Logger
	private static Logger log = Logger.getLogger(Log.class.getName());
	
	/**
	 * Prints log at the beginning of a test
	 * @param sTestCaseName - Name Assigned to testcase
	 * @author reggy
	 */
	public static void startTestCase(String sTestCaseName) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		log.info("*********************************************************************");
		log.info("########################"+sTestCaseName+"#############################");
		log.info("Test Started: "+dateFormat.format(date));
		}
	
	/**
	 * Prints log at the end of a test
	 * @param sTestCaseName - Name Assigned to testcase
	 * @author reggy
	 */
	public static void endTestCase(String sTestCaseName) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		log.info("*********************************************************************");
		log.info("########################"+sTestCaseName+"#############################");
		log.info("Test Ended: "+dateFormat.format(date));
		log.info("*********************************************************************");
		}
	
	/**
	 * Logs an informational message
	 * @param strMessage - informational message
	 * @author reggy
	 */
	public static void info(String strMessage) {
		log.info(strMessage);
	}
	
	/**
	 * Logs an error message
	 * @param strMessage - error message
	 * @author reggy
	 */
	public static void error(String strMessage) {
		log.error(strMessage);
	}
	
}
