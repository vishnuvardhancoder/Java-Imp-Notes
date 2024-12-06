import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCTest{
    static final synchronized public void main(String... abc) throws Exception{
        //Take values from console
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Id:");
        int id = s.nextInt();
        System.out.print("Enter Name:");
        String name = s.next();
        System.out.print("Enter Address:");
        String address = s.next();
        System.out.print("Enter Mobile Number:");
        long mobile = s.nextLong();

        //Step 1: Load the Driver
        Class.forName("com.mysql.jdbc.Driver");

        //Step 2: Connection Establishment
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kgisl_fourth_batch", "root", "root");

        //Step 3: Create PreparedStatement
        PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setString(3, address);
        ps.setLong(4, mobile);

        //Step 4: Execute the Query
        int ch = ps.executeUpdate();
        System.out.println(ch + " row(s) affected");

        //Step 5: Release the resources
        ps.close();
        con.close();
    }
}