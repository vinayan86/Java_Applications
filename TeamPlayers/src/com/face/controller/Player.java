package com.face.controller;

import java.util.Scanner;

import com.face.bo.PlayerBO;
import com.face.bo.SkillBO;
import com.face.bo.TeamBO;
import com.face.dao.PlayerDAO;
import com.face.dao.SkillDAO;
import com.face.dao.TeamDAO;

public class Player {
	public String PlayerName;
	public String Country;
	public Skill Skill;
	public Team Team;

	public Player() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PlayerName ");
		String PlayerName=sc.nextLine();

		System.out.println("Enter Country ");
		String Country=sc.nextLine();


		
		PlayerBO pb=new PlayerBO();
	
		pb.setPlayerName(PlayerName);
		pb.setCountry(Country);

	
		
		this.PlayerName=pb.getPlayerName();
		this.Country=pb.getCountry();
		 
			System.out.println("Enter Skill ");
			String Skill=sc.nextLine();
			
			SkillBO b=new SkillBO();
			b.setSkill(Skill);
			SkillDAO sd=new SkillDAO();
			this.Skill=sd.FindBySkillName(b.getSkill());
			
			System.out.println("Enter Team ");
			String Team=sc.nextLine();
			TeamBO t=new TeamBO();
			t.setTeamName(Team);
			TeamDAO td=new TeamDAO();
			this.Team=td.FindByTeamName(t.getTeamName());
			




	PlayerDAO ps=new PlayerDAO();
	ps.createPlayer(this);	


	}

	public Player(String PlayerName,String Country, String Skill,String Team) {





	}

}
