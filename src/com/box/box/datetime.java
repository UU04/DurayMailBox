package com.box.box;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class datetime {
	
	
	public static String TotalTime, TotalDate,hour;
	public static void getdatetime() {
		
		String thisTail;
	    LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH");
	    DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("mm");
	    DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("ss");
	    DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("yyyy");
	    DateTimeFormatter myFormatObj4 = DateTimeFormatter.ofPattern("MM");
	    DateTimeFormatter myFormatObj5 = DateTimeFormatter.ofPattern("dd");
	    String formattedDate = myDateObj.format(myFormatObj);
	    String formattedDate1 = myDateObj.format(myFormatObj1);
	    String formattedDate2 = myDateObj.format(myFormatObj2);
	    String formattedDate3 = myDateObj.format(myFormatObj3); //�⵵
	    String formattedDate4 = myDateObj.format(myFormatObj4); //��
	    String formattedDate5 = myDateObj.format(myFormatObj5); //��
	   
	    int yay = Integer.parseInt(formattedDate);
	     
	    if(yay >= 13) {
	    	//13�� - 24���� �� 
	    	hour = Integer.toString(yay - 12);
	    	thisTail = "����";
	    }else {
	    	hour = Integer.toString(yay);
	    	thisTail = "����";
	    }
	    
	    
	    
	    TotalTime = thisTail + " " + hour + "�� " + formattedDate1 + "�� " + formattedDate2 + "��";
	    TotalDate = formattedDate3 + "�� " + formattedDate4 + "�� " + formattedDate5 + "��";
	    
	}
}
