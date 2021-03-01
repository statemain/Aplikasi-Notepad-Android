package ei.eseptiyadi.notesapp.model.auth;

import com.google.gson.annotations.SerializedName;

public class UserbaruItem{

	@SerializedName("password")
	private String password;

	@SerializedName("hash_useraccess")
	private String hashUseraccess;

	@SerializedName("level")
	private String level;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("dateuser_created")
	private String dateuserCreated;

	@SerializedName("username")
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setHashUseraccess(String hashUseraccess){
		this.hashUseraccess = hashUseraccess;
	}

	public String getHashUseraccess(){
		return hashUseraccess;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setDateuserCreated(String dateuserCreated){
		this.dateuserCreated = dateuserCreated;
	}

	public String getDateuserCreated(){
		return dateuserCreated;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"UserbaruItem{" + 
			"password = '" + password + '\'' + 
			",hash_useraccess = '" + hashUseraccess + '\'' + 
			",level = '" + level + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",dateuser_created = '" + dateuserCreated + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}