/* Import the packages */
package test;
import java.io.Serializable;
import java.util.*;
import java.sql.*;
import java.io.*;
/* Creating an class FindAuthor and implement the Serializable interface */
public class FindAuthor implements Serializable
{
	private String url, authorName, driverName, authorId;
	private Vector result;
	/* Setting the url property */
	public void setUrl(String url)
	{
		if(url!= null)
		  this.url = url;
	}
	/* Setting the author name */
	public void setAuthorId(String authorId)
	{
		if (authorId != null)
			this.authorId = authorId;
	}
	/* Setting the driver name */
	public void setDriverName(String driverName)
	{
		if (driverName != null)
			this.driverName = driverName;
	}
	public String getAuthorId()
	{
			return(this.authorId);	
	}

	/* Defining a method to fetch the result from the author database */
	public Vector getResult()
	{
		Vector v = new Vector();
		try
		{

			/* Loading the driver */
			Class.forName(driverName);
			/* Creating a connection */
			Connection con = DriverManager.getConnection(url, "hr", "hr");
			/* Creating a prepared statment */
			PreparedStatement stat = con.prepareStatement( "SELECT * FROM authors WHERE authorid = ? ");
			/* Set the author name in the query */
			stat.setString(1,authorId);
			/* Get the result set from the author table */
			ResultSet rs = stat.executeQuery();
			if(rs.next())
			{
				/* Storing the resultset in the vector v */
				v.addElement(rs.getString("first_name"));
				v.addElement(rs.getString("last_name"));
				v.addElement(rs.getString("mobile"));
			}
		}
		/* Handling the exception */
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		/* Returning the vector */
		this.result = v;
		return result;
	}// End getResult()
}/* End FindAuthor */
