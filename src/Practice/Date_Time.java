/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import javafx.scene.control.DatePicker;


public class Date_Time {
    
    public static String getDateAndTime() {
                    
        Calendar now = Calendar.getInstance();
        System.out.println(now);
		String hour=Integer.toString(LocalDateTime.now().getHour());
		if(hour.length()==1) hour="0"+hour;
		String min=Integer.toString(LocalDateTime.now().getMinute());
		if(min.length()==1) min="0"+min;
		String second=Integer.toString(LocalDateTime.now().getSecond());
		if(second.length()==1) second="0"+second;
		return LocalDate.now()+" "+hour+"."+min+"."+second;
	}
    
    public static void main(String[] args) {
        String str;
        str = getDateAndTime();
        System.out.println(str);
    }
    
}
