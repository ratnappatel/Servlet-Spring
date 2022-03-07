package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.LoginUser;

public class LoginUserDatabase {
	
	public boolean validate(LoginUser user)
	{
		String sql = "select email, password from customer where email = ?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, user.getEmail());
			ResultSet rs = statement.executeQuery();
			String useremail = null,userpass = null;
			if(rs.next()) {
				 useremail = rs.getString(1);
				 userpass = rs.getString(2);
				 if(user.getEmail().equals(useremail) && user.getPassword().equals(userpass)) {
					 return true;
				 } 
				 // throw invalid credenial exception
			}
			// throw record does not exist exception
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		

		return false;
		
	}

}
