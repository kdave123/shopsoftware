import java.sql.*;
import java.util.Scanner;
class Menu{
public static void main(String args[]) {
String url = "jdbc:mysql://localhost:3306/";
String dbName = "database";
String driver = "com.mysql.cj.jdbc.Driver";
String userName = "root";
String dbpassword = "";

Scanner sc = new Scanner(System.in);

//http://localhost/phpmyadmin/
int ch=0;

System.out.println("\n\n\n*************************************************************");

System.out.println("\tWELCOME \t TO \t SHOP");

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
System.out.println("Quantity : ");
int cquantity = sc.nextInt();
System.out.println("Price : ");
float cprice = sc.nextFloat();
System.out.println("Width : ");
int cwidth = sc.nextInt();
System.out.println("Length: ");
int clength = sc.nextInt();


// Inserting row into a table
String insert_qry="insert into customer (name,quantity,price,width,length) VALUES ('"+cname+"','"+cquantity+"','"+cprice+"','"+cwidth+"','"+clength+"')";
int num_row_updated= stmt.executeUpdate(insert_qry);
System.out.println("No. of rows inserted="+num_row_updated);
System.out.println("***************BILL SUMMARY**********************");
System.out.println("\nName: "+cname+"\nPrice: "+cprice+"\nQuantiy: "+cquantity+"\nTotal Price: "+cprice*cquantity);
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


String ret_str="select * from customer";
ResultSet rs=stmt.executeQuery(ret_str);  

// In emp table 4 fields are there i.e. id,name,
System.out.println("\n\n|ID|\t|NAME|\t\t|QUANTITY|\t|PRICE|\t|WIDTH|\t|LENGTH|");
while(rs.next())  
System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getInt(4)+"   \t" +rs.getFloat(5)+"     "+rs.getInt(6)+"      "+rs.getInt(7)); 

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
	
	System.out.println("\n\n\t1.Customer Entry \n\t2.View Customer Details \n\t3.Exit Shop");
	ch = sc.nextInt();


}//end switch

}

}//end main
}//endclass
