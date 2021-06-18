import java.io.IOException;

public class mathfun extends Rooms {

	public static double math(double n, double n2) throws IOException {
		
		
		double total = 0;
		int numi;
		int numb;
		double nums[] = new double[20];
		double temp;
		
		String sufix2;
		String sufix;
		
		for (int i = 0; i < n; ++i) {
		if(i == 0) {
			sufix2 = "st";
		}else if (i == 1) {
			sufix2 = "nd";
		}else if (i == 2) {
			sufix2 = "rd";
		}else {
			sufix2 = "th";
		}
		
		
		for (int b = 0; b < n2; ++b) {
		
		if(b == 0) {
			sufix = "st";
		}else if (b == 1) {
			sufix = "nd";
		}else if (b == 2) {
			sufix = "rd";
		}else {
			sufix = "th";
		}
		
		numi = i + 1;
		numb = b + 1;
		
		System.out.println("How many seconds would you like to wash each dish? ");
		System.out.println("enter your " + numb + sufix + " number of seconds to wash " + numb + sufix + " dish for the " + numi + sufix2 + " time");
	
		 temp = myObj.nextDouble();
		 r.PR(2);
		 nums[(int) numb] = temp;
		 
		 total = nums[(int) numb] + total;
		}
		
	}  
		r.SR(2,12);
		return total;
		
	}

}


 
