package com.face.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.face.controller.Player;
import com.face.util.ConnectionManager;

public class PlayerDAO {
	
	public void createPlayer(Player p)
	{

//System.out.println(p.PlayerName);
//System.out.println(p.Country);
//System.out.println(p.Skill.Skill);
//System.out.println(p.Team.TeamName);
	
		ConnectionManager cn = new ConnectionManager();
		
		
		String s="INSERT INTO `player`( `name`, `country`, `skill_id`, `team_id`) VALUES ('"+ p.PlayerName+"','"+p.Country+"','"+p.Skill.SkillID+"','"+p.Team.TeamID+"')";
		System.out.println(s);
		
			try {
				Statement St = ConnectionManager.getConnection().createStatement();
				St.executeUpdate(s);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	public List<Player> getPlayerDetails(String SkillName)
	{

		
		return null;
		
	}
	public  List<Player> getAllPlayerDetails()
	{
ConnectionManager cn = new ConnectionManager();
		
		
		String s="SELECT p.name as player,country,t.name as team,s.name as skill FROM player as p,Team as t ,Skill s WHERE p.skill_id=s.id and p.team_id=t.id";
		System.out.println(s);
	      ArrayList<Player> list=new ArrayList<>(); 
			try {
				Statement St = ConnectionManager.getConnection().createStatement();
			ResultSet rs=St.executeQuery(s);
		
			
			 
			  while(rs.next())
			            {
			                 
			         
			            
			                 
			                 
			           
			            }
	      
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return al;
		
	}
}
