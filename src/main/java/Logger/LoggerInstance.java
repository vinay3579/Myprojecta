package Logger;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LoggerInstance {
	
	public static Logger logger;
	File directory = new File ("");
	//creating absolute path for saving the log file inside the folder
	String absolutepath	=	directory.getAbsolutePath();
	//This is to get location for creating log file.
	String str_logFilePath = absolutepath+File.separator+"log";
	
	
	public LoggerInstance() throws IOException
	{	//generating current date and time in format "dd-MM-yyyy HH:mm:ss"
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date();
		String current_dateTime = dateFormat.format(date);
		// replacing "_" and ":" and " " by "_"(underscore) 
		current_dateTime = current_dateTime.replace("-", "_");
		current_dateTime = current_dateTime.replace(" ", "_") ;
		current_dateTime = current_dateTime.replace(":", "_") ;
		
		File f1 = new File(str_logFilePath) ; 
		//checking the file exist or not
		if(!f1.exists()){
			f1.mkdir();
		}
		
		// creating Name for Log file
		String str_logFilePath1 = str_logFilePath+File.separator+"AutomationLogFile_"+current_dateTime+".log";
		//creating log file 
		File f2 =  new File(str_logFilePath1);
		
		
		
	if(logger==null)
		{
		try{
			f2.createNewFile();
			// Printing Finalaya in starting of the logger and formatting with spaces and next line
			logger = Logger.getLogger("Finalaya");
			FileAppender apndr = new FileAppender(new PatternLayout("%p %t %c - %m%n"),str_logFilePath1,true);
			//appending the logger
			logger.addAppender(apndr);
		}
		catch(Exception e)
		{
			System.out.println("Log file is not initialized");
		}
		}
	}
}