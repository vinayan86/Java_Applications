package com.face.bo;

public class TeamBO {
	public Long getTeamID() {
		return TeamID;
	}
	public void setTeamID(Long teamID) {
		TeamID = teamID;
	}
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	private Long TeamID;
	private String TeamName;

}
