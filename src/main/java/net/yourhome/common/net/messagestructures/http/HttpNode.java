package net.yourhome.common.net.messagestructures.http;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HttpNode {

	private String name; // e.g. XBMC Title 
	private int id;
	private int parentId;
	private List<HttpCommand> commands = new ArrayList<HttpCommand>();
	
	public HttpNode() {
		
	}
	public HttpNode(ResultSet result) throws SQLException {
		this.name = result.getString("name");
		this.id = result.getInt("id");
		this.parentId = result.getInt("parentId");
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the parentId
	 */
	public int getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	/**
	 * @return the commands
	 */
	public List<HttpCommand> getCommands() {
		return commands;
	}
	/**
	 * @param commands the commands to set
	 */
	public void addCommand(HttpCommand command) {
		this.commands.add(command);
	}
	
	
	
	
}
