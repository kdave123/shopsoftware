import java.sql.*;
import java.util.Scanner;
class Menu{
public static void main(String args[]) {
String url = "jdbc:mysql://localhost:3306/";
String dbName = "optician";
String driver = "com.mysql.cj.jdbc.Driver";
String userName = "root";
String dbpassword = "";

Scanner sc = new Scanner(System.in);

//http://localhost/phpmyadmin/
int ch=0;

System.out.println("\n\n\n*************************************************************");

System.out.println("\tWELCOME \t TO \t OPTICIAN'S \t SHOP");

System.out.println("*************************************************************");


while(true) {

switch(ch){
	case 1:
try {
// loading driver
Class.forName(driver);
// Connection set up with database named as user
Connection con = DriverManager.getConnection(url+dbName,userName,dbpassword);
Statement stmt=con.createStatement();	

System.out.println("Name : ");
String cname = sc.next();
System.out.println("Power of Lens: ");
float cpol = sc.nextFloat();
System.out.println("Quantity : ");
int cquantity = sc.nextInt();
System.out.println("Price : ");
float cprice = sc.nextFloat();
System.out.println("Width : ");
int cwidth = sc.nextInt();
System.out.println("Length: ");
int clength = sc.nextInt();
System.out.println("Frame Design: ");
String cdesign = sc.next();

// Inserting row into a table
String insert_qry="insert into optician.customer (name,pol,quantity,price,width,length,design) VALUES ('"+cname+"','"+cpol+"','"+cquantity+"','"+cprice+"','"+cwidth+"','"+clength+"','"+cdesign+"')";
int num_row_updated= stmt.executeUpdate(insert_qry);
System.out.println("No. of rows inserted="+num_row_updated);
System.out.println("***************BILL SUMMARY**********************");
System.out.println("\nName: "+cname+"\nPrice: "+cprice+"\nQuantiy: "+cquantity+"\nTotal Price: "+cprice*cquantity+"\nFrame Design: "+cdesign);
System.out.println("*************************************************");
// Closing the statement and connection
stmt.close();
con.close();
}
catch (Exception e) {
System.out.println("Case 1 Exception");
System.out.println(e);
}
ch=0;
	break;
	


	case 2:
		

		

try {
// loading driver
Class.forName(driver);
// Connection set up with database named as user
Connection con = DriverManager.getConnection(url+dbName,userName,dbpassword);
Statement stmt=con.createStatement();	
// Inserting row into a table
//String insert_qry= "insert into emp (id,name,salary,city) value (11,'Reshma',45000,'Thane')";
//int num_row_updated= stmt.executeUpdate(insert_qry);
//System.out.println("No. of rows inserted="+num_row_updated);

String ret_str="select * from customer";
ResultSet rs=stmt.executeQuery(ret_str);  

// In emp table 4 fields are there i.e. id,name,
System.out.println("\n\n|ID|\t|NAME|\t|POWER OF LENS|\t|QUANTITY|\t|PRICE|\t|WIDTH|\t|LENGTH|\t|DESIGN|");
while(rs.next())  
System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getFloat(3)+"\t\t"+rs.getInt(4)+"   \t" +rs.getFloat(5)+"     "+rs.getInt(6)+"      "+rs.getInt(7)+"\t\t"+rs.getString(8) ); 

// Closing the statement and connection
stmt.close();
con.close();
}
catch (Exception e) {
System.out.println(e);
}
	ch=0;
	break;

	case 3:
		System.out.println("\n\n\n*************************************************");

System.out.println("\tTHANK YOU");

System.out.println("*************************************************");	
		System.exit(0);
	ch=0;
	break;

	default:
	
	System.out.println("\n\n\t1.Customer Entry \n\t2.View Customer Details \n\t3.Exit Optician Shop");
	ch = sc.nextInt();


}//end switch

}

}//end main
}//endclass