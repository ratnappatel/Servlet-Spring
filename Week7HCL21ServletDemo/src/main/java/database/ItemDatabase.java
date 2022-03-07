package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Item;

public class ItemDatabase {

	private static Connection con = DBConnection.getConnection();

	public List<Item> getAllItems() throws SQLException
	{
		List<Item> items = new ArrayList<>();
		String sql = "select  * from item";
		// 3) statement
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next())
		{
			Item item = new Item();
			item.setItemid(rs.getString(1));
			item.setItemname(rs.getString(2));
			item.setManufacturer(rs.getString(3));
			item.setPrice(rs.getDouble(4));
			items.add(item);
		}
		return items;
	}
}
