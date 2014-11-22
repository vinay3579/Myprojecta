package Reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import FunctionLibraries.AutomationConstants;
import Logger.LoggerInstance;

public class CustomMethodReport {
	
	public static HashMap hm = new HashMap();
	
	
	/* Method Name: createFolderorFile
	 * Description: 
	 * 		This method will create the folder/file
	 * Parameters: Function accepts 2 parameters
	 * 		1. isFile- boolean: true- if we want to create a file. false- if we want to create folder
	 * 		2. folderOrFile- File: File type object that speicifies the path of file/folder
	 * Created By: Bal Govind
	 * Created Date: 03-09-2014
	 * */
	
	public File createFolderorFile(boolean isFile, File folderOrFile) throws IOException
	{
		if(isFile)
		{
			if(!folderOrFile.exists())
				folderOrFile.createNewFile();			
		} else {
			if(!folderOrFile.exists())
			{
				folderOrFile.mkdir();
			}
		}
		return folderOrFile;
	}
	
	/* Method Name: startHtmlPage
	 * Description: 
	 * 		This method will generate the Header of internal execution html report
	 * Parameters: 
	 * 		1. out- PrintWriter- handle of html file generated using createWriter method 
	 * Created By: Bal Govind
	 * Created Date: 03-09-2014
	 * */
	
	public void startHtmlPage(PrintWriter out) throws IOException
	{
		out.println("<html>");
		out.println("<head>");
		
		//Java Script function to generate the S.No.Column
		String jsFunction = "function GenerateColId() { var tableId = document.getElementById('reportTable'); var cols = tableId.rows[0].cells.length; var a =1;" +
				"for(var i =1; i < tableId.rows.length; i++) {	tableId.rows[i].cells[0].innerText = a; a++;}}";

		out.println("<Script>" + jsFunction + "</Script>" + "</head>");
		out.println("<title> My Custom Report Methods</title>");
	
		out.println("</head>");
		
		out.println("<body onload = GenerateColId()><br/>");

		// This will generate the header of the html for the internal html
		
		out.println("<table border='1' width='100%' id = \"reportTable\"> " +
						"<tr bgcolor=\"grey\">" +
							"<td>S.No.</td>" +
							"<td>Date</td>" +
							"<td>Time</td>" +
							"<td>Action</td>" +
							"<td>Expected Result</td>" +
							"<td>Actual Result</td>" +
							"<td>Screenshot</td>" +
							"<td>Status</td>" +
						"</tr>");
		
	}
	
	/* Method Name: generateExecutionReport
	 * Description: 
	 * 		This method will generate the execution report of internal execution
	 * Parameters: 
	 * 		1. out- PrintWriter
	 * 		2. action- String: Action of test case
	 * 		3. expectedResult: Expected Result of Test Case
	 * 		4. actualResutl: Actual Result of Test case
	 * 		5. isPassed: Boolean- true if test case is passed false otherwise
	 * 		6. screenshot: Path of screenshot taken during failures
	 * Created By: Bal Govind
	 * Created Date: 03-09-2014
	 * */
	
	public void generateExecutionReport(PrintWriter out, String action, String expectedResult, String actualResult, boolean isPassed, String screenshot) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		if(expectedResult==null || expectedResult=="")
		{
			out.println("<tr>" +
					  "<td colspan=\"8\" height = 10 align = center bgcolor = lightgrey>" + action + "</td>" + 
					  "</tr>"	
					 );
		} else {
			out.println(
					(isPassed == true ? "<tr bgcolor = lightgreen>" : "<tr bgcolor = \"FF6666\">") +
						  "<td>" + "</td>" +
						  "<td width = \"8%\">" + dateFormat.format(new Date()) + "</td>" +
						  "<td>" + timeFormat.format(new Date().getTime()) + "</td>" +
						  "<td>" + action + "</td>" +
						  "<td>" + expectedResult + "</td>" +
						  "<td>" + actualResult + "</td>" +
						  "<td><a target = \"_blank\"" + " href=" + '"' + (screenshot==null ? "" : screenshot) + '"'  + ">" +(screenshot == null ? "" : screenshot)+ "</a></td>" +
						  "<td>" + (isPassed == true ? "PASS" : "FAIL") + "</td>" +
						  "</tr>"
				);
		}
		
		out.flush();
		
	}
	
	/** Finishes HTML Stream */
	public void endHtmlPage(PrintWriter out)
	{
		out.println("</table></body></html>");
	}
	
	
	/*
	 * Description: This Method will Create a file of html type and return the handle of file
	 * parameter: method: String- This method accepts the a String that contains the method name. 
	 * 								Html file will be create using this method name 
	 * Created By: Bal Govind
	 * Created Date: 03-09-2014
	 * 
	 * */
	public PrintWriter createWriter(String methodName) throws IOException
	{
		System.out.println("create writer method");
		
		//Read the Property file value
		Properties prop = new Properties();
		InputStream inputConfig = new FileInputStream(AutomationConstants.PROPERTY_FILE_NAME);
		prop.load(inputConfig);
		String folder = prop.get(AutomationConstants.INTERNAL_REPORT).toString();
		
		File directory = new File ("");
		String absolutepath	=	directory.getAbsolutePath();
		
		//This is to get location for creating log file. This value is comming from build.xml 
		String str_reportFilePath = absolutepath+File.separator+folder;
		
		File f1 = new File(str_reportFilePath);
		File outFolder = createFolderorFile(false, f1);
		
		int reportCount = outFolder.list().length + 1;
		String reportName = methodName + "_"+ reportCount + ".html";
		
		String reportPath = outFolder + "\\" + reportName ;
		
		//put the file name in HashMap against method Name. This hashmap is used for the linking of internal verification and overall execution reoport
		
		hm.put(methodName, reportPath);
		
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outFolder, reportName))));
	}
}
