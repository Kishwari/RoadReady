package com.hexaware.roadready.dto;

public class AgentDTO {
         
	private int agentId;
	private String username;
	private String password;
	
	public AgentDTO() {
		super();

	}
	public AgentDTO(int agentId, String username, String password) {
		super();
		this.agentId = agentId;
		this.username = username;
		this.password = password;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AgentDTO [agentId=" + agentId + ", username=" + username + ", password=" + password + "]";
	}
}
