package formating;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
class WinDemo{

	

	public static void main(String arg[]){
		Date dNow = new Date( );
	      SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd");
	      System.out.println("Current Date: " + ft.format(dNow));
		
	

	}







}