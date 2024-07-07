package kapil;
import java.sql.*;

public class jdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String urlString = "jdbc:postgresql://localhost:5432/DemoDatabase";
		String userString = "postgres";
		String passwordString= "kapil";
		
		//optional 
		//Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection(urlString,userString,passwordString);
		System.out.println("connection established");
		
//=================read only particular column value==================
		
		/*
		Statement st= connection.createStatement();
		String query =  "select sname from student where sid = 1";
		ResultSet rs= st.executeQuery(query);
		// next will return true or false, if rs return something or not
		//System.out.println(rs.next());
		//If we have just executed the query, if we are in beginning,  the next will be pointing to first row.
		rs.next();
		String name =rs.getString("sname");
		System.out.println("Name is " + name);
		*/
		
//=====read all the rows values===================
		
		/*
		Statement st= connection.createStatement();
		String query =  "select * from student";
		ResultSet rs= st.executeQuery(query);
		
		
		while(rs.next()) {
			System.out.print(rs.getInt(1) +  " - ");
			System.out.print(rs.getInt(2) +   " - ");
			System.out.println(rs.getString(3));
		}
		*/
		
	
//========Perform CRUD Operations==============================
	/*	
//		String query = "insert into student values (6,92,'Shubham')";
		String query = "update student set sname='raj' where marks = 92";
//		String query= "delete from student where sid=1";
		Statement st= connection.createStatement();
		//execute command to run the insert, delete, update query
		//execute query returns true if it is select query,
		
		System.out.println(st.execute(query));
		connection.close();
		System.out.println("Connection Closed");
		*/
		
		
//==========use preparedStatement=============================	
		int sid = 101;
		int marks = 91;
		String sname = "Rahul Yadav";
		String query  = "insert into student values(?,?,?)";
		PreparedStatement st= connection.prepareStatement(query);
		st.setInt(1, sid);
		st.setInt(2, marks);
		st.setString(3,sname);
		st.execute();
		
		connection.close();
		System.out.println("Connection Closed");
	}

}


/* 
 * Problems with Statement
   what if we have variables, id, name and marks and we want to pass them in query string",
   it will be difficult, since we need a query like
   String query = "insert into student values (" + sid + "," + marks + ",'" + sname + ")";
   
   it may lead to sql injection;
   
   //we use preparedStatement for caching queries
    * 
    * String query  = "insert into student values(?,?,?)";
    * 
    */


 
 




