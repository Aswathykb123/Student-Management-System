package com.studentmanagement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.studentmanagement.dao.SchoolEmployeeOperations;
import com.studentmanagement.dao.StudentOperations;

public class App 
{
    public static void main( String[] args )
    {
    	boolean status=true;
    	try
    	{
    		do
    		{
        Scanner scan=new Scanner(System.in);
        System.out.println("=======================================================================");
        System.out.println("                            Welcome to XYZ School                        ");
        System.out.println("=======================================================================");
        System.out.println("1 -> School Employee");
        System.out.println("2 -> Student");
        System.out.println("3 -> Faculty");
        System.out.println("Enter your user type:");
        int userType=scan.nextInt();
        
        if(userType==1)
        {
        	
        	System.out.println("Enter your Employee id:");
        	int eid=scan.nextInt();
        	System.out.println("Enter Password:");
        	String password=scan.next();
        	
        	SchoolEmployeeOperations ob=new SchoolEmployeeOperations();
        	//System.out.println(ob.login(eid, password));
        	if(ob.login(eid, password))
        	{
                System.out.println("=======================================================================");
        		System.out.println("Login successfull!!");
                System.out.println("=======================================================================");
        		System.out.println("1.Create New Student Profile\r\n"
        				+ "2.Delete Student Profile\r\n"
        				+ "3.View Student Datails\r\n"
        				+ "4.Update Student Details\r\n");
        	int op=scan.nextInt();
        	if(op==1)
        	{
        		System.out.println("Enter Student Id for the new user:");
        		long studentid=scan.nextLong();
        		System.out.println("Enter Student Name:");
        		String studentname=scan.next();
        		System.out.println("Enter Student address:");
        		String address=scan.next();
        		System.out.println("Enter phone number:");
        		long phone=scan.nextLong();
        		System.out.println("Enter Admission Class of new student:");
        		String admittingclass=scan.next();
        		System.out.println("Enter Tution fee of student:");
        		double tutionfee=scan.nextDouble();
        		System.out.println("Set Password for the new student :");
        		String password1=scan.next();
        		if(ob.openstudentProfile(studentid,studentname,address,phone,admittingclass,tutionfee,password1))
        		{
                    System.out.println("=======================================================================");
        			System.out.println("Account created successfully!!");
                    System.out.println("=======================================================================");

        		}
        		else
        		{   System.out.println("=======================================================================");
        			System.out.println("Problem in account creation!!");
                    System.out.println("=======================================================================");

        		}
        	}
        	else if(op==2)
        	{
        		System.out.println("Enter the Student Id for deleting profile:");
        		long proId=scan.nextLong();
        		if(ob.deleteProfile(proId))
        		{
        			System.out.println("Profile Deleted successfully!!");
        		}
        		else
        		{
        			System.out.println("Problem occurred!!");
        		}
        	}
        	else if(op==3)
        	{
        		System.out.println("Enter Student Id to check the Information:");
        		long proId=scan.nextLong();
        		ResultSet result=ob.studentInfoCheck(proId);
        		while(result.next())
        		{
        			System.out.println("=======================================================================");
        			System.out.println("--- Student Details ----");
                    System.out.println("=======================================================================");

        			System.out.println("Student Name :"+result.getString(2));
        			System.out.println("Student Address :"+result.getString(3));
        			System.out.println("Student Phone number :"+result.getLong(4));
        			System.out.println("Class :"+result.getString(5));
        			System.out.println("Tution Fees:"+result.getDouble(6));
        			
        		}
        	}
        	
        }
        }
        else if(userType==2)
        {
        	System.out.println("Enter your Student id:");
        	long sid=scan.nextLong();
        	System.out.println("Enter Password:");
        	String password1=scan.next();
        	
        	StudentOperations ob1=new StudentOperations();
        	
        	if(ob1.login(sid, password1))
        	{
        		System.out.println("=======================================================================");
        		System.out.println("Login Successfull!!");
        		System.out.println("=======================================================================");

        		System.out.println("1.View My Profile\r\n"
        				+ "2.View My MarkSheet\r\n"
        				+ "3.View Tution Fee");
        		int operation=scan.nextInt();
        		if(operation==1)
        		{
        			
            		System.out.println("Enter your Student Id to check the Information:");
            		long proId=scan.nextLong();
            		ResultSet result=ob1.profilecheck(proId);
            		while(result.next())
            		{
            			System.out.println("=======================================================================");
            			System.out.println("--- My Profile ----");
                        System.out.println("=======================================================================");

            			System.out.println("Name :"+result.getString(2));
            			System.out.println("Address :"+result.getString(3));
            			System.out.println("Phone number :"+result.getLong(4));
            			System.out.println("Class :"+result.getString(5));
            			System.out.println("Tution Fees:"+result.getDouble(6));
            			
            		}
        			
        		}
        		else if(operation==2)
        		{
        			
        			
        			System.out.println("Enter your Student Id to check the MarkSheet:");
            		long proId=scan.nextLong();
            		ResultSet result=ob1.marksheetInfo(proId);
            		while(result.next())
            		{
            			System.out.println("=======================================================================");
            			System.out.println("--- My MarkSheet ----");
                        System.out.println("=======================================================================");

            			System.out.println("Name :"+result.getString(2));
            			System.out.println("Maths Marks :"+result.getString(3));
            			System.out.println(" Science Marks:"+result.getLong(4));
            			System.out.println("English Marks :"+result.getString(5));          			
            			
            		}
        		}
        		else if(operation==3)
        		{
        			System.out.println("Enter your Student Id to check the Attendance:");
            		long proId=scan.nextLong();
            		ResultSet result=ob1.AttendanceInfo(proId);
            		while(result.next())
            		{
            			System.out.println("=======================================================================");
            			System.out.println("--- My MarkSheet ----");
                        System.out.println("=======================================================================");

            			System.out.println("Name :"+result.getString(2));
            			System.out.println("Attendance :"+result.getString(6));
        			
        			
            		}
        		}
        		
        		else
            	{
            		System.out.println("Login unsuccessfull!!");
            	}
            	
        		}
        		}
            }
        	
            while(status=true);
        		
        	
            
        		}	
        
        	catch(Exception e)
        	{
        		System.out.println(e.getMessage());
        	}
            
            
            
        }
    }

        
        	
       









