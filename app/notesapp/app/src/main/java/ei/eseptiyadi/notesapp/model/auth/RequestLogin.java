package ei.eseptiyadi.notesapp.model.auth;

import com.google.gson.annotations.SerializedName;

public class RequestLogin{

	@SerializedName("code")
	private int code;

	@SerializedName("pass")
	private String pass;

	@SerializedName("level")
	private String level;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private String id;

	@SerializedName("message")
	private String message;

	@SerializedName("user")
	private String user;

	@SerializedName("hash")
	private String hash;

	@SerializedName("status")
	private boolean status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setPass(String pass){
		this.pass = pass;
	}

	public String getPass(){
		return pass;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setUser(String user){
		this.user = user;
	}

	public String getUser(){
		return user;
	}

	public void setHash(String hash){
		this.hash = hash;
	}

	public String getHash(){
		return hash;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"RequestLogin{" + 
			"code = '" + code + '\'' + 
			",pass = '" + pass + '\'' + 
			",level = '" + level + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",message = '" + message + '\'' + 
			",user = '" + user + '\'' + 
			",hash = '" + hash + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}