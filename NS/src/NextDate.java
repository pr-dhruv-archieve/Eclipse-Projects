import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NextDate {
	public static void main(String[] argv) throws FileNotFoundException, IOException {
		System.out.print("Date in DD-MM-YYYY : ");
		String d = new java.util.Scanner(System.in).next();
		
		String[] token = d.split("-");
		
		Integer date = Integer.parseInt(token[0]);
		Integer month = Integer.parseInt(token[1]);
		Integer year = Integer.parseInt(token[2]);
		if (date < 1 || month < 1 || year < 1) {
			System.out.println("Wrong date");
			System.exit(1);
		}
			
		if(month == 2 && year % 4 == 0 && date > 29) {
			System.out.println("Wrong date");
			System.exit(1);
		}
		else if(month == 2 && year % 4 != 0 && date > 28) {
			System.out.println("Wrong date");
			System.exit(1);
		}
		else if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ) && date > 31) {
			System.out.println("Wrong date");
			System.exit(1);
		}
		
		else if((month == 4 || month == 6 || month == 9 || month == 11) && date > 30) {
			System.out.println("Wrong date");
			System.exit(1);
		}
		else if (month == 12 && date == 31) {
			date = 01;
			month = 01;
			year++;
			System.out.println(date+"-"+month+"-"+year);
			return;
		}
		else {
			if(year % 4 == 0 && month == 2) {
				if(date == 29) {
					date = 01;
					month++;
				}
				else {
					date++;
				}
				System.out.println(date+"-"+month+"-"+year);
				return ;
			}
			else if (year % 4 != 0 && month == 2){
				if (date == 28) {
					date = 01;
					month++;
				}
				else {
					date++;
				}
				System.out.println(date+"-"+month+"-"+year);
				return;
			}
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				if(date == 30) {
					month++;
					date = 01;
				}
				else {
					date++;
				}
				System.out.println(date+"-"+month+"-"+year);
				return;
			}
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if(date == 31) {
					date = 01;
					month++;
				}
				else
					date++;
				System.out.println(date+"-"+month+"-"+year);
				return;
			}
		}
		System.out.println("Invalid Date");
		
	}
	
}