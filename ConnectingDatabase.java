import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
   

  public class ConnectingDatabase
{
     public static void main(String[] args)
     {
        int choice;
        do{
        try (
          Scanner in = new Scanner(System.in)) {
	        try
			{
	
	System.out.println("Enter a word:");
	   String word = in.next();
	   Class.forName("com.mysql.jdbc.Driver");

	// this is to make a connection.
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Main","root","December1196");
	//used to make a statement.
	    PreparedStatement ps = con.prepareStatement("insert into word (words) values(?)");
	//set my words that i included in my database
	    ps.setString(1,word);
	//exceution
	    ps.executeUpdate();
	//display database of word table
	     System.out.println("Database after insertion of your word");
	 Statement st = con.createStatement();
	 ResultSet rs = st.executeQuery("select * from word");
	  while(rs.next()){
	System.out.println(rs.getString(1));
	}
	
	     con.close();
	}
	
	   catch(ClassNotFoundException |SQLException c){
	System.out.println(c.getMessage());
	}
	System.out.println("Do you want to enter more word(1 for yes)");
	   choice = in.nextInt();
}

    }while(choice==1);

System.out.println("Frequency of each word present in the database is:");

  Map<String,Integer> frequency = new LinkedHashMap<>();

      try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/wordoccurences","root","123456");
          Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("Select * from word");
               while(rs.next()){

  String s = rs.getString(1);

  if(frequency.get(s)==null){

     frequency.put(s,1);
      }
      else{

    frequency.put(s,frequency.get(s)+1);
}
}

     con.close();
}
   catch(ClassNotFoundException | SQLException s){
System.out.println(s.getMessage());
}

     Set<String> key = frequency.keySet();
      for(String k:key){
System.out.println("Word: "+k+" frequency: "+frequency.get(k));
}
}
}