package com.gl.CaseStudy1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffMain {

	public static Double percentageCalculation (Double total) {
		double percentage = (total/300)*100;
		return percentage;
	}
	
	public static Double totalCalculation (Applicant applicant) {
		double s1 = applicant.getSubject1Mark();
		double s2 = applicant.getSubjec2Mark();
		double s3 = applicant.getSubject3Mark();
		if(s1 < 50||s2 < 50||s3 < 50) 
		{
			
		
			return 0.0;
	}
		else
		{
			return s1 + s2 + s3;
		}
	}
	
	public static void main(String[] args) {
		List<Applicant> listAppli = new ArrayList<Applicant>();
		DecimalFormat df = new DecimalFormat("0.00");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of applicants: ");
		int num = Integer.parseInt(s.nextLine());
		
		for(int i=0;i<num;i++) {
			try {
			System.out.println("Enter Applicant details: ");
			String applDetails = s.nextLine();
			
			String [] detailsSplit = applDetails.split(",");
			double sub1 = Double.parseDouble(detailsSplit[1]);
			double sub2 = Double.parseDouble(detailsSplit[2]);
			double sub3 = Double.parseDouble(detailsSplit[3]);
			if(sub1 < 0 ||sub1 > 100 ||sub2 < 0|| sub2 >100 ||sub3 < 0 || sub3 >100) {
				throw new MarksException("marks cannot be less than 0 or greater than 100");
			}
			
			Applicant applicant = new Applicant(detailsSplit[0],sub1,sub2,sub3,null,null);
			
			double total = totalCalculation(applicant);
			applicant.setTotal(total);
			double percentage = Double.parseDouble(df.format(percentageCalculation(total)));
			applicant.setPercentage(percentage);
			listAppli.add(applicant);
			}
			catch(MarksException ne){
				System.out.println(ne.getMessage()); 
			}
		}
		
		for(Applicant applicant: listAppli) {
			if(applicant.getPercentage()>70)
				System.out.println(applicant);
		}
	}

}
