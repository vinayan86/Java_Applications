package com.face.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.face.controller.Team;
import com.face.controller.Team;
import com.face.util.ConnectionManager;

public class TeamDAO {

	public Team FindByTeamName(String TeamName)
	{
		ConnectionManager con =new ConnectionManager();
		Statement st = null;
		try {
			st=con.getConnection().createStatement();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int id = 0;
		
		String sql="Select id from Team where name='"+ TeamName +"'";

			
			ResultSet rs = null;
			try {
				rs = st.executeQuery(sql);
				while(rs.next())
				{
					id=rs.getInt("id");	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			 Team t =new Team();
				t.TeamName=TeamName;
				t.TeamID=id;
				return t;
		
	}
	

	public Team FindByTeamID(long TeamID)
	{
		
		return null;
		
	}
}
