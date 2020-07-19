package spreadsheet;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Eg {
	static ArrayList<String> ar;
	public static void Getfrom_database() throws Exception
	{
		ar=new ArrayList<String>();
		Connection con=Getcon();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select name from student");
		
		while(rs.next())
		{
		ar.add(rs.getString(1));
		}
	}
	public static Connection Getcon()
	{
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlite:/home/subash54/Desktop/Attendance.db");
			return con;
		} catch (SQLException e) {
			return null;
			
		}
	}
	public static void Absentees() throws Exception
	{
		Scanner sc=new Scanner (new File("/home/subash54/Downloads/h.csv"));
		sc.nextLine();
		
		while(sc.hasNextLine()==true)
		{
			String []s=sc.nextLine().split(",");
			String temp=s[0];
			
			ar.remove(temp);
			
		}
		sc.close();
		
	}
	public static void display() throws Exception
	{
		Connection con=Getcon();
		Statement st=con.createStatement();
		
		for(String d:ar)
		{
			String sa="select * from student where name='"+d+"'";
			
			ResultSet rs=st.executeQuery(sa);
			while(rs.next())
			{
				System.out.print(rs.getString("name")+" ");
				System.out.print(rs.getString("address")+" ");
				System.out.print(rs.getString("phno")+" ");
				System.out.println();
				
			}
		}
		con.close();
		
	}
	public static void main(String []args ) throws Exception
	{
		Getfrom_database();
		Absentees();
		display();
		
		
	}
		

}
