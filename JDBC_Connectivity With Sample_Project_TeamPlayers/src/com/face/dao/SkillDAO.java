package com.face.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.face.controller.Skill;
import com.face.util.ConnectionManager;

public class SkillDAO {
	
	public Skill FindBySkillName(String SkillName)
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
		
		String sql="Select id from skill where name='"+ SkillName +"'";
		
			
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
			
			 Skill s =new Skill();
				s.Skill=SkillName;
				s.SkillID=id;
				return s;
		
		
	}
	

	public Skill FindBySkillID(long SkillID)
	{
		return null;
		
	}
	

}
