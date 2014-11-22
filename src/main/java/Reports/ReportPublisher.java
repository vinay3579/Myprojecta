package Reports;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import FunctionLibraries.AutomationConstants;
import Logger.LoggerInstance;


public class ReportPublisher implements IReporter {
	
	public static PrintWriter  f_out;
	CustomMethodReport cm = new CustomMethodReport();
	File path=null;
	/*
	 * Description: This method will generate the report with overall execution status. 
	 * Pass results are marked in green color while failed in red.
	 * This method is provided by TestNG. We are overriding this method and providing our customization to generated the report.
	 * Created By: Bal Govind
	 * Created Date: 03-09-2014
	 * */
	
	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> suites, String outdir)
	{
		//Create the html file using createWriter method
		try {
			f_out = createWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ITestContext tc = null;
		
		//Generate the body of html file and attach the logo
		
		startHtmlPage(f_out);
		
		for (ISuite suite : suites) {
        //Following code gets the suite name
        String suiteName = suite.getName();
            
	    //Getting the results for the said suite
	    Map<String, ISuiteResult> suiteResults = suite.getResults();
	    
		for (ISuiteResult sr : suiteResults.values()) {
	    	tc = sr.getTestContext();
	      }
		//Getting all passed test cases
		IResultMap passedTests = tc.getPassedTests();
		
		//Getting all failed test cases
		IResultMap failedTests = tc.getFailedTests();
		
		int totalTestCases = passedTests.size() + failedTests.size();
			
		// Generate the header of report
		
		f_out.println("<table border='1' width='1000' id = \"reportTable\">");
		

		f_out.println("<tr bgcolor=\"#ADD8E6\">" +
				"<td colspan=\"3\" align = \"center\">" +
				"Total Test Cases: " + totalTestCases +	"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Passed: " + passedTests.size() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Failed: " + failedTests.size() +
				"</td></tr>");
		f_out.println("<tr bgcolor=\"grey\">" +
				"<td>S.No.</td>" +
				"<td>Test Methods</td>" +
				"<td>Status</td>" +
			"</tr>");
		
	      // Print all passed test cases
		
	      for( ITestResult r: passedTests.getAllResults()) {
	    	  
	    	  f_out.println("<tr bgcolor = lightgreen>" +
					  "<td>" + "</td>" +
					  "<td><a" + " href=" + '"' + cm.hm.get(r.getName())+ '"'  + ">" +r.getName() + "</a></td>" + //target = \"_blank\"
					  "<td>" + "Pass" + "</td>" +
					  "</tr>");  
	      }
	      
		// Print all failed test cases
	      for( ITestResult r1: failedTests.getAllResults()) {
	    	  f_out.println("<tr bgcolor = \"FF6666\">" +
					  "<td>" + "</td>" +
					  "<td><a" + " href=" + '"' + cm.hm.get(r1.getName()) + '"'  + ">" +r1.getName() + "</a></td>" + //target = \"_blank\"
					  "<td>" + "Fail" + "</td>" +
					  "</tr>");   
	      }
        }
		
		endHtmlPage(f_out);

		//Open the Report after execution of all test cases
		try {
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		f_out.flush();
		f_out.close();
		
	}
	
	
	/* Method Name: startHtmlPage
	 * Description: 
	 * 		This method will start generating the html file and set the logo of application 
	 * Parameters: 
	 * 		1. out- PrintWriter- handle of html file generated using createWriter method 
	 * Created By: Bal Govind
	 * Created Date: 03-09-2014
	 * */
	
	public void startHtmlPage(PrintWriter out)
	{
		File logoDir = new File("");
		String absolutePath = logoDir.getAbsolutePath();
		File logoFile = new File(absolutePath+"\\finalaya_logo.jpg");
		
		out.println("<html>");
		out.println("<html");
		out.println("<head>");
		
		//Java Script function to generate the S.No.Column
		String jsFunction = "function GenerateColId() { var tableId = document.getElementById('reportTable'); var cols = tableId.rows[0].cells.length; var a =1;" +
				"for(var i =2; i < tableId.rows.length; i++) {tableId.rows[i].cells[0].innerText = a; a++;}}";

		out.println("<Script>" + jsFunction + "</Script>" + "</head>");
		out.println("<title> My Custom Report </title>");
	
		out.println("</head>");
		
		out.println("<body bgcolor =\"#F0FFFF\" onload = GenerateColId()><br/>");
		out.println("<h2 style=\"font-family:verdana;\"> <img src=\""+ logoFile +"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Test Case Execution Report</img></h2>");
		
		out.flush();
		
	}
	
	/*
	 * Description: This Method will finishes the html stream.
	 * Parameter: out: PrintWriter- It is the handle of html file.			
	 * Created By: Bal Govind
	 * Created Date: 03-09-2014
	 * 
	 * */
	
	private void endHtmlPage(PrintWriter out)
	{
		out.println("</table>");
		out.println("</body></html>");
	}
	
	
	/*
	 * Description: This Method will Create a file of html type and return the handle of file.
	 * 				A folder will be created that is provided in the property file that has name as "finalExecutionReport"			
	 * Created By: Bal Govind
	 * Created Date: 03-09-2014
	 * 
	 * */
	
	public PrintWriter createWriter() throws IOException
	{	
		Properties prop = new Properties();
		InputStream inputConfig = new FileInputStream(AutomationConstants.PROPERTY_FILE_NAME);
		prop.load(inputConfig);
		
		String folder = prop.getProperty(AutomationConstants.FINAL_REPORT);
		
		File directory = new File ("");
		
		//Fetch the absolute path of project
		String absolutepath	=	directory.getAbsolutePath();
		String str_reportFilePath = absolutepath+File.separator+folder;
		File f1 = new File(str_reportFilePath);
		
		// Create the folder with the name provided in property file
		File outFolder = cm.createFolderorFile(false, f1);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		
		String reportDirName = dateFormat.format(date);
		
		File currentDateReportFolder = new File(outFolder + "\\" + reportDirName);
		
		// Create a folder with the Current Date
		if(!currentDateReportFolder.exists())
			currentDateReportFolder.mkdir();
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
		Date time = new Date();
		
		String tim1 = timeFormat.format(time);
		
		//Append the time in html file.
		String rPath = "Finalaya Execution Report_" + tim1;
		path = new File(currentDateReportFolder + "\\" + rPath + ".html") ;
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(currentDateReportFolder, rPath + ".html"))));
	}
}
